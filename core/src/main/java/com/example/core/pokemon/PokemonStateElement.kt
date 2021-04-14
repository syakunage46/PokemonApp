package com.example.core.pokemon

import com.example.core.state.StateElement

data class PokemonStateElement(
    val pokemonDataList: List<PokemonData>
): StateElement