package com.example.core.pokemon

import com.example.core.repository.Repository

interface PokemonRepository: Repository {
    val getPokemonList: GetPokemonList
}

interface GetPokemonList {
    suspend operator fun invoke(limit: Int, offset: Int): List<PokemonData>
}