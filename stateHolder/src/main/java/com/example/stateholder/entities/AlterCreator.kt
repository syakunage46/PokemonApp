package com.example.stateholder.entities

import com.example.core.pokemon.PokemonData
import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State

interface AlterCreatorInterface {
    suspend fun create(action: Action)
}

class AlterCreator(private val alterStateReceiver: AlterStateReceiver): AlterCreatorInterface {
    private fun prevPokemonDataList(state: State): List<PokemonData>
        = state[PokemonStateElement::class]?.pokemonDataList ?: emptyList()

    // ビルダーを使っていい感じにできそう
    // Stateそのものを返すものとか
    private fun createAlterPokemonStateElement(
        pokemonDataList: (State) -> List<PokemonData> = { prevPokemonDataList(it) },
        isLoading: Boolean = false,
        error: Throwable? = null
        ): Alter {
        return Alter{ state ->
            State(state.stateElements.plus(Pair(PokemonStateElement::class,
                PokemonStateElement(pokemonDataList(state),isLoading,error)
            )))
        }
    }

    override suspend fun create(action: Action) {
        when(action) {
            is PokemonAction.StartLoading -> {
                alterStateReceiver.dispatch(
                    createAlterPokemonStateElement(isLoading = true)
                )
            }
            is PokemonAction.Failed -> {
                alterStateReceiver.dispatch(
                    createAlterPokemonStateElement(error = action.payload)
                )
            }
            is PokemonAction.GetList -> {
                alterStateReceiver.dispatch(
                    createAlterPokemonStateElement(pokemonDataList = {action.payload})
                )
            }
            is PokemonAction.AddList -> {
                alterStateReceiver.dispatch(
                    createAlterPokemonStateElement(pokemonDataList = {prevPokemonDataList(it) + action.payload})
                )
            }
        }
    }
}