package com.example.pokemonrepository.repository

class PokemonRepository(private val pokemonDataSource: PokemonDataSource)  {
    suspend fun getPokemonList(limit: Int) = pokemonDataSource.getPokemonList(limit)
}