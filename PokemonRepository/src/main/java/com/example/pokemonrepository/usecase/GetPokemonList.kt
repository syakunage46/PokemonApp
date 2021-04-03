package com.example.pokemonrepository.usecase

import com.example.pokemonrepository.data.PokemonRepositoryItem
import com.example.pokemonrepository.repository.PokemonRepository

interface GetPokemonList {
    suspend operator fun invoke(limit: Int): List<PokemonRepositoryItem>
}

class GetPokemonListInteractor (private val pokemonRepository: PokemonRepository): GetPokemonList {
    override suspend operator fun invoke(limit: Int): List<PokemonRepositoryItem> {
        return pokemonRepository.getPokemonList(limit)
    }
}