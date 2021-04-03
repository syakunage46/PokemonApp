package com.example.pokemonrepository.api

import com.example.pokemonrepository.api.usecase.GetPokemonListFromApi
import com.example.pokemonrepository.api.usecase.GetPokemonListFromApiInteractor
import com.example.pokemonrepository.usecase.GetPokemonList

interface PokemonApiUseCases {
    val getPokemonList: GetPokemonListFromApi
}

class PokemonApiUseCaseBus(private val apiConnector: PokeApiConnector): PokemonApiUseCases {
    override val getPokemonList = GetPokemonListFromApiInteractor(apiConnector)
}