package com.example.pokemonrepository.usecase

import com.example.pokemonrepository.data.PokemonRepositoryItem
import com.example.pokemonrepository.repository.datasource.PokemonDataSource
import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.datasource.remote.PokemonRemoteDataSource

interface GetPokemonList {
    suspend operator fun invoke(limit: Int, offset: Int): List<PokemonRepositoryItem>
}

class GetPokemonListInteractor (private val pokemonDataSource: PokemonDataSource): GetPokemonList {
    override suspend operator fun invoke(limit: Int, offset: Int): List<PokemonRepositoryItem> {
        var pokemonList: List<PokemonRepositoryItem> = pokemonDataSource.local.getPokemonList(limit, offset)
        return if (pokemonList.size >= limit) {
            pokemonList
        } else {
            pokemonList = pokemonDataSource.remote.getPokemonList(limit, offset)
            pokemonList.forEach { pokemonDataSource.local.addPokemon(it) }
            pokemonList
        }
    }
}