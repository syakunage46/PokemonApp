package com.example.pokemonrepository.api

class PokemonApiService(private val pokemonApiUseCases: PokemonApiUseCases): PokemonApi {
    override suspend fun getPokemonList(limit: Int) = pokemonApiUseCases.getPokemonList(limit)
}