package com.example.pokemonrepository.repository.remote

import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.data.PokemonProperty

class PokemonRemoteDataSourceService(private val pokemonApi: PokemonApi): PokemonRemoteDataSource {
    override suspend fun getPokemonList(limit: Int): List<PokemonProperty> = pokemonApi.getPokemonList(limit)
}