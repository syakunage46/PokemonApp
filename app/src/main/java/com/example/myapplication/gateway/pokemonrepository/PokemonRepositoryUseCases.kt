package com.example.myapplication.gateway.pokemonrepository

import com.example.myapplication.gateway.pokemonrepository.usecase.GetPokemonList
import com.example.myapplication.gateway.pokemonrepository.usecase.GetPokemonListInteractor
import com.example.pokemonrepository.repository.PokemonRepository

interface PokemonRepositoryUseCases {
    val getPokemonList: GetPokemonList
}

class PokemonRepositoryUseCasesService(private val pokemonRepository: PokemonRepository): PokemonRepositoryUseCases {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(pokemonRepository)
}