package com.example.pokemonrepository.api.response

import com.example.pokemonrepository.data.PokemonSpecies
import com.squareup.moshi.Json

data class PokemonSpeciesResponse (
    val id: Long,
    val name: String,
    val names: List<Name>,
    val order: Long,

    @Json(name = "evolution_chain")
    val evolutionChain: EvolutionChain,

    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>,

    val genera: List<Genus>,
    val generation: NameAndURL
) {
    fun toPokemonSpecies(): PokemonSpecies {
        return PokemonSpecies(
            id, name, names, order
        )
    }

    val nameJp: String?
        get() = names.find { it.language.name == "ja" }?.name
}

data class EvolutionChain (
    val url: String
)

data class FlavorTextEntry (
    @Json(name = "flavor_text")
    val flavorText: String,

    val language: NameAndURL,
    val version: NameAndURL
)

data class Genus (
    val genus: String,
    val language: NameAndURL
)

data class Name (
    val language: NameAndURL,
    val name: String
)