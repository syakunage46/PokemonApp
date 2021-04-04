package com.example.myapplication.flux

import com.example.myapplication.module.pokemonlist.store.PokemonListActionType
import com.example.myapplication.module.pokemonlist.store.PokemonListEventType
import kotlinx.coroutines.flow.Flow

interface Dispatcher<ActionType, StateType> {
    val actionCreator: ActionCreator<ActionType, *>
    val state: Flow<(StateType) -> StateType>
}