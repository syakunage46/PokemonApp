package com.example.pokemonrepository

import com.example.pokemonrepository.repository.PokemonRepository
import com.example.pokemonrepository.usecase.GetPokemonList
import com.example.pokemonrepository.usecase.GetPokemonListInteractor

interface PokemonRepositoryUseCases {
    val getPokemonList: GetPokemonList
}

class PokemonRepositoryUseCaseBus(private val repository: PokemonRepository):
    PokemonRepositoryUseCases {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(repository)
}