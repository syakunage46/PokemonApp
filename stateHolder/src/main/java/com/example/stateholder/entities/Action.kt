package com.example.stateholder.entities

import com.example.core.pokemon.PokemonData

interface Action

sealed class PokemonAction {
    class GetList(val payload: List<PokemonData>) : Action
    class AddList(val payload: List<PokemonData>) : Action
    class StartLoading(): Action
    class Failed(val payload: Throwable): Action
}