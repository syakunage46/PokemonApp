package com.example.redux.pokemon

import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State
import com.example.redux.annotation.ElementReducer
import com.example.redux.base_component.Action
import com.example.redux.base_component.ElementReducerInterface

@ElementReducer
class PokemonReducer: ElementReducerInterface<PokemonStateElement> {
    override fun reduce(state: State, action: Action): PokemonStateElement {
        val element = state[PokemonStateElement::class] ?: PokemonStateElement(emptyList(), false, null)
        return when(action) {
            is PokemonAction.InLoading -> {
                element.copy(isLoading = true)
            }
            is PokemonAction.Failed -> {
                element.copy(isLoading = false, error = action.payload)
            }
            is PokemonAction.GetList -> {
                element.copy(pokemonDataList = action.payload, isLoading = false)
            }
            is PokemonAction.AddList -> {
                element.copy(pokemonDataList = element.pokemonDataList + action.payload, isLoading = false)
            }
            else -> element
        }
    }

}

