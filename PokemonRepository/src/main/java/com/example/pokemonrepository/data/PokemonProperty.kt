package com.example.pokemonrepository.data

data class PokemonProperty (
    val id: Long,
    val nameEng: String,
    val nameJp: String?,
    val weight: Long,
    val height: Long,
) {
    val name: String
        get() = nameJp ?: nameEng
}