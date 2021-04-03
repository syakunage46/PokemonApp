package com.example.pokemonrepository.data

import com.example.pokemonrepository.api.response.Name

data class PokemonSpecies(
    val id: Long,
    val name: String,
    val names: List<Name>,
    val order: Long,
)