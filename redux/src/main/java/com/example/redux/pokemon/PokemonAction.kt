package com.example.redux.pokemon

import com.example.core.pokemon.PokemonData
import com.example.redux.base_component.Action

interface PokemonAction: Action {
    class GetList(val payload: List<PokemonData>): PokemonAction
    class AddList(val payload: List<PokemonData>): PokemonAction
    class InLoading: PokemonAction
    class Failed(val payload: Throwable): PokemonAction
}