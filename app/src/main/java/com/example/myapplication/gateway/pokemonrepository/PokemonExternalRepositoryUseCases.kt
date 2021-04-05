package com.example.myapplication.gateway.pokemonrepository

import com.example.myapplication.gateway.pokemonrepository.usecase.GetPokemonList
import com.example.myapplication.gateway.pokemonrepository.usecase.GetPokemonListInteractor
import com.example.pokemonrepository.repository.PokemonRepository

interface PokemonExternalRepositoryUseCases {
    val getPokemonList: GetPokemonList
}

class PokemonExternalRepositoryUseCaseBus(private val pokemonRepository: PokemonRepository): PokemonExternalRepositoryUseCases {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(pokemonRepository)
}