package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.data.PokemonData

class PokemonStateValue(
    val pokemonList: List<PokemonData>?,
    val isLoading: Boolean
)