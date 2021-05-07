package com.example.core.navigation

interface Navigation {
    class PokemonList(): Navigation
    class PokemonDetail(val id: Long): Navigation
}