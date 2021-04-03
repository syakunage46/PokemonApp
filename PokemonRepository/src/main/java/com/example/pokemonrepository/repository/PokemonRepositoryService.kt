package com.example.pokemonrepository.repository

import com.example.pokemonrepository.data.PokemonProperty
import com.example.pokemonrepository.db.PokemonEntity
import com.example.pokemonrepository.repository.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.remote.PokemonRemoteDataSource

class PokemonRepositoryService(private val pokemonLocalDataSource: PokemonLocalDataSource,
                               private val pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonRepository  {
    override suspend fun getPokemonList(limit: Int): List<PokemonProperty> {
        var pokemonList: List<PokemonProperty> = pokemonLocalDataSource.getPokemonList(limit)
        return if (pokemonList.size >= limit) {
            pokemonList
        } else {
            pokemonList = pokemonRemoteDataSource.getPokemonList(limit)
            pokemonList.forEach { pokemonLocalDataSource.addPokemon(it) }
            pokemonList
        }
    }
}