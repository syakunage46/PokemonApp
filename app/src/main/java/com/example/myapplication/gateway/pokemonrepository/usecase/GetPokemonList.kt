package com.example.myapplication.gateway.pokemonrepository.usecase

import com.example.myapplication.data.PokemonData
import com.example.pokemonrepository.PokemonRepositoryUseCases

interface GetPokemonList {
    suspend operator fun invoke(limit: Int, offset: Int): List<PokemonData>
}

class GetPokemonListInteractor (private val pokemonRepositoryUseCases: PokemonRepositoryUseCases): GetPokemonList {
    override suspend operator fun invoke(limit: Int, offset: Int): List<PokemonData> = pokemonRepositoryUseCases.getPokemonList(limit, offset).map {PokemonData.from(it)}
}