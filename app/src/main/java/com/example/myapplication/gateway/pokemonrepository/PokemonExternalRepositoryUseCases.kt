package com.example.myapplication.gateway.pokemonrepository

import com.example.myapplication.gateway.pokemonrepository.usecase.GetPokemonList
import com.example.myapplication.gateway.pokemonrepository.usecase.GetPokemonListInteractor
import com.example.pokemonrepository.PokemonRepositoryUseCases

interface PokemonExternalRepositoryUseCases {
    val getPokemonList: GetPokemonList
}

class PokemonExternalRepositoryUseCaseBus(private val pokemonRepositoryUseCases: PokemonRepositoryUseCases): PokemonExternalRepositoryUseCases {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(pokemonRepositoryUseCases)
}