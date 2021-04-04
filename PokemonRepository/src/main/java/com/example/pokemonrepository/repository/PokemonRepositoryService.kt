package com.example.pokemonrepository.repository

import com.example.pokemonrepository.data.PokemonRepositoryItem
import com.example.pokemonrepository.repository.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.remote.PokemonRemoteDataSource

class PokemonRepositoryService(private val pokemonLocalDataSource: PokemonLocalDataSource,
                               private val pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonRepository  {
    override suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonRepositoryItem> {
        var pokemonList: List<PokemonRepositoryItem> = pokemonLocalDataSource.getPokemonList(limit, offset)
        return if (pokemonList.size >= limit) {
            pokemonList
        } else {
            pokemonList = pokemonRemoteDataSource.getPokemonList(limit, offset)
            pokemonList.forEach { pokemonLocalDataSource.addPokemon(it) }
            pokemonList
        }
    }
}