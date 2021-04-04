package com.example.pokemonrepository.repository

import com.example.pokemonrepository.data.PokemonRepositoryItem

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonRepositoryItem>
}