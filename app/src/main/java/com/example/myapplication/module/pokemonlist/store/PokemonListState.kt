package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.State

data class PokemonListState(
    val pokemonList: List<PokemonData>?,
    val isLoading: Boolean
): State