package com.example.pokemonrepository.repository

import com.example.pokemonrepository.usecase.GetPokemonList

interface PokemonRepository {
    val getPokemonList: GetPokemonList
}