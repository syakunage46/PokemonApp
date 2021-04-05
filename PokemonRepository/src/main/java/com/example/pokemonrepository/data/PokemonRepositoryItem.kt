package com.example.pokemonrepository.data

import com.example.pokemonrepository.api.response.NameAndURL

data class PokemonRepositoryItem (
    val id: Long,
    val order: Long,
    val nameEng: String,
    val nameJp: String?,
    val weight: Long,
    val height: Long,
    val genera: String,
    val flavorText: String,
    val frontImageUrl: String
) {
    val name: String
        get() = nameJp ?: nameEng
}