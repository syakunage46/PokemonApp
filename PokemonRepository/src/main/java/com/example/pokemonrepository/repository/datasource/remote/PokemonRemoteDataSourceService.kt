package com.example.pokemonrepository.repository.datasource.remote

import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.data.PokemonRepositoryItem

class PokemonRemoteDataSourceService(private val pokemonApi: PokemonApi): PokemonRemoteDataSource {
    override suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonRepositoryItem> = pokemonApi.getPokemonList(limit, offset)
}