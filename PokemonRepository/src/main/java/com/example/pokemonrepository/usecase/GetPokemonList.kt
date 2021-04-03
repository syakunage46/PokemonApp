package com.example.pokemonrepository.usecase

import com.example.pokemonrepository.data.PokemonProperty
import com.example.pokemonrepository.repository.PokemonRepository
import com.example.pokemonrepository.repository.PokemonRepositoryService

interface GetPokemonList {
    suspend operator fun invoke(limit: Int): List<PokemonProperty>
}

class GetPokemonListInteractor (private val pokemonRepository: PokemonRepository): GetPokemonList {
    override suspend operator fun invoke(limit: Int): List<PokemonProperty> {
        return pokemonRepository.getPokemonList(limit)
    }
}