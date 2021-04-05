package com.example.pokemonrepository.repository.datasource.remote

import com.example.pokemonrepository.data.PokemonRepositoryItem

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonRepositoryItem>
}