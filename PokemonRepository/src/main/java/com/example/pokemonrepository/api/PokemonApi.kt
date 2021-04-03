package com.example.pokemonrepository.api

import com.example.pokemonrepository.data.PokemonProperty

interface PokemonApi {
    suspend fun getPokemonList(limit: Int): List<PokemonProperty>
}