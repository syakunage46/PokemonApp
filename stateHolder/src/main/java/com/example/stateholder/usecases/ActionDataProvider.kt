package com.example.stateholder.usecases

import com.example.stateholder.data.PokemonData

interface ActionDataProvider {
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>
}