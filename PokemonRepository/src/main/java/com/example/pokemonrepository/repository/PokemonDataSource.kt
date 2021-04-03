package com.example.pokemonrepository.repository

import com.example.pokemonrepository.data.PokemonProperty

interface PokemonDataSource {
    suspend fun getPokemonList(limit: Int): List<PokemonProperty>
}