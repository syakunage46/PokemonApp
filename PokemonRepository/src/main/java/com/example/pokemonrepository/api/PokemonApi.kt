package com.example.pokemonrepository.api

import com.example.pokemonrepository.data.PokemonRepositoryItem

interface PokemonApi {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonRepositoryItem>
}