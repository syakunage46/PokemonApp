package com.example.pokemonrepository.api.response

import com.squareup.moshi.Json

data class PokemonSpeciesResponse (
    @Json(name = "base_happiness")
    val baseHappiness: Long,

    @Json(name = "capture_rate")
    val captureRate: Long,

    val color: NameAndURL,

    @Json(name = "egg_groups")
    val eggGroups: List<NameAndURL>,

    @Json(name = "evolution_chain")
    val evolutionChain: EvolutionChain,

    @Json(name = "evolves_from_species")
    val evolvesFromSpecies: Any? = null,

    @Json(name = "flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntry>,

    @Json(name = "form_descriptions")
    val formDescriptions: List<Any?>,

    @Json(name = "forms_switchable")
    val formsSwitchable: Boolean,

    @Json(name = "gender_rate")
    val genderRate: Long,

    val genera: List<Genus>,
    val generation: NameAndURL,

    @Json(name = "growth_rate")
    val growthRate: NameAndURL,

    val habitat: NameAndURL,

    @Json(name = "has_gender_differences")
    val hasGenderDifferences: Boolean,

    @Json(name = "hatch_counter")
    val hatchCounter: Long,

    val id: Long,

    @Json(name = "is_baby")
    val isBaby: Boolean,

    @Json(name = "is_legendary")
    val isLegendary: Boolean,

    @Json(name = "is_mythical")
    val isMythical: Boolean,

    val name: String,
    val names: List<Name>,
    val order: Long,

    @Json(name = "pal_park_encounters")
    val palParkEncounters: List<PalParkEncounter>,

    @Json(name = "pokedex_numbers")
    val pokedexNumbers: List<PokedexNumber>,

    val shape: NameAndURL,
    val varieties: List<Variety>
)

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

data class PalParkEncounter (
    val area: NameAndURL,

    @Json(name = "base_score")
    val baseScore: Long,

    val rate: Long
)

data class PokedexNumber (
    @Json(name = "entry_number")
    val entryNumber: Long,

    val pokedex: NameAndURL
)

data class Variety (
    @Json(name = "is_default")
    val isDefault: Boolean,

    val pokemon: NameAndURL
)