package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.data.PokemonData


sealed class PokemonListActionType {
    class LoadSuccess(val pokemonDataList: List<PokemonData>) : PokemonListActionType()
    class Error(val error: Throwable) : PokemonListActionType()
}