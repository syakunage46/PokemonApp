package com.example.stateholder.entities

import com.example.stateholder.data.PokemonData

data class State(
    val pokemonDataList: List<PokemonData> = emptyList()
)