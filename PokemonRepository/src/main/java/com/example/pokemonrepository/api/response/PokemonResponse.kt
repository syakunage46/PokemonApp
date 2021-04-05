package com.example.pokemonrepository.api.response

import com.example.pokemonrepository.data.PokemonRepositoryItem
import com.squareup.moshi.Json

data class PokemonResponse (
    val id: Long,
    val order: Long,
    val name: String,
    val types: List<Type>,
    val weight: Long,
    val height: Long,
    val species: NameAndURL,
    val sprites: Sprites
) {
    private val frontDefault: String
        get() = sprites.frontDefault

    fun toPokemonRepositoryItem(speciesResponse: PokemonSpeciesResponse): PokemonRepositoryItem {
        return PokemonRepositoryItem(
            id,
            order,
            name,
            speciesResponse.nameJp,
            weight,
            height,
            speciesResponse.generaJp,
            speciesResponse.flavorTextJp,
            frontDefault
        )
    }
}

data class Sprites (
    @Json(name = "front_default")
    val frontDefault: String
)

data class Type (
    val slot: Long,
    val type: NameAndURL
)