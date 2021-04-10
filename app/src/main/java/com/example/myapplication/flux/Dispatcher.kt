package com.example.myapplication.flux

import com.example.myapplication.module.pokemonlist.store.PokemonListActionType
import com.example.myapplication.module.pokemonlist.store.PokemonListEventType
import kotlinx.coroutines.flow.Flow

interface Dispatcher<ActionType, StateType: State> {
    val actionFlow: Flow<ActionType>
    val alterFlow: Flow<Alter<StateType>>
    fun dispose()
}