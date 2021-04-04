package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.data.PokemonData

sealed class PokemonListEventType {
    class OnCreate: PokemonListEventType()
    class OnSwipeRefresh : PokemonListEventType()
    class OnScrolledToEnd(val offset: Int) : PokemonListEventType()
}