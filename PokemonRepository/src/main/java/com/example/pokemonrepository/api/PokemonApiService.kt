package com.example.pokemonrepository.api

import com.example.pokemonrepository.data.PokemonProperty

class PokemonApiService(private val pokemonApiUseCases: PokemonApiUseCases): PokemonApi {
    override suspend fun getPokemonList(limit: Int) = pokemonApiUseCases.getPokemonList(limit)
}