package com.example.pokemonrepository.repository

import com.example.pokemonrepository.data.PokemonProperty

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int): List<PokemonProperty>
}