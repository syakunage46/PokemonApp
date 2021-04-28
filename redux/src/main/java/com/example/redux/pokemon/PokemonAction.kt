package com.example.redux.pokemon

import com.example.core.pokemon.PokemonData

interface PokemonAction {
    class GetList(val payload: List<PokemonData>): PokemonAction
    class AddList(val payload: List<PokemonData>): PokemonAction
    class StartLoading(): PokemonAction
    class Failed(val payload: Throwable): PokemonAction
}