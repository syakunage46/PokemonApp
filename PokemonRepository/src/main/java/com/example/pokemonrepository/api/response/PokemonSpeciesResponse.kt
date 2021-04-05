package com.example.pokemonrepository.api.response

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
    val nameJp: String?
        get() = names.find { it.language.name == "ja" }?.name

    val flavorTextJp: String
        get() = flavorTextEntries.find { it.language.name == "ja" }?.flavorText ?: ""

    val generaJp: String
        get() = genera.find { it.language.name == "ja" }?.genus ?: ""
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