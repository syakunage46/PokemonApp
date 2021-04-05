package com.example.pokemonrepository.repository.datasource.local

import com.example.pokemonrepository.data.PokemonRepositoryItem

interface PokemonLocalDataSource {
    suspend fun addPokemon(pokemon: PokemonRepositoryItem)
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonRepositoryItem>
}