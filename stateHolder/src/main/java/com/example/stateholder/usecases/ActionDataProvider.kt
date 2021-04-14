package com.example.stateholder.usecases

import com.example.core.pokemon.PokemonData

interface ActionDataProvider {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>
}