package com.example.myapplication.gateway.pokemonrepository.usecase

import com.example.myapplication.data.PokemonData
import com.example.pokemonrepository.repository.PokemonRepository

interface GetPokemonList {
    suspend operator fun invoke(limit: Int, offset: Int): List<PokemonData>
}

class GetPokemonListInteractor (private val pokemonRepository: PokemonRepository): GetPokemonList {
    override suspend operator fun invoke(limit: Int, offset: Int): List<PokemonData> = pokemonRepository.getPokemonList(limit, offset).map {PokemonData.from(it)}
}