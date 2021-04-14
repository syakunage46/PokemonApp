package com.example.stateholder.entities

import android.util.Log
import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State
import com.example.stateholder.usecases.AlterDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

interface AlterCreatorInterface {
    suspend fun create(action: Action)
}

class AlterCreator(private val alterStateReceiver: AlterStateReceiver): AlterCreatorInterface {
    override suspend fun create(action: Action) {
        when(action) {
            is PokemonAction.GetList -> {
                alterStateReceiver.dispatch(Alter{ state ->
                    State(state.stateElements.plus(Pair(PokemonStateElement::class,
                                            PokemonStateElement(action.payload,false,null)
                                            ))
                    )
                })
            }
        }
    }
}