package com.example.pokemonrepository.api.response

import com.example.pokemonrepository.data.PokemonProperty
import com.example.pokemonrepository.data.PokemonSpecies
import com.squareup.moshi.Json

data class PokemonResponse (
    val id: Long,
    val name: String,
    val types: List<Type>,
    val weight: Long,
    val height: Long,

    val abilities: List<Ability>,

    @Json(name = "base_experience")
    val baseExperience: Long,

    val forms: List<NameAndURL>,

    @Json(name = "game_indices")
    val gameIndices: List<GameIndex>,

    @Json(name = "held_items")
    val heldItems: List<Any?>,

    @Json(name = "is_default")
    val isDefault: Boolean,

    @Json(name = "location_area_encounters")
    val locationAreaEncounters: String,

    val moves: List<Move>,

    val order: Long,

    @Json(name = "past_types")
    val pastTypes: List<Any?>,

    val species: NameAndURL,
    val sprites: Sprites,
    val stats: List<Stat>
) {
    fun toPokeMonProperty(nameJp: String? = null): PokemonProperty {
        return PokemonProperty(
            id, name, nameJp, weight, height
        )
    }
}

data class Ability (
    val ability: NameAndURL,

    @Json(name = "is_hidden")
    val isHidden: Boolean,

    val slot: Long
)

data class GameIndex (
    @Json(name = "game_index")
    val gameIndex: Long,

    val version: NameAndURL
)

data class Move (
    val move: NameAndURL,

    @Json(name = "version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>
)

data class VersionGroupDetail (
    @Json(name = "level_learned_at")
    val levelLearnedAt: Long,

    @Json(name = "move_learn_method")
    val moveLearnMethod: NameAndURL,

    @Json(name = "version_group")
    val versionGroup: NameAndURL
)

data class GenerationV (
    @Json(name = "black-white")
    val blackWhite: Sprites
)

data class GenerationIv (
    @Json(name = "diamond-pearl")
    val diamondPearl: Sprites,

    @Json(name = "heartgold-soulsilver")
    val heartgoldSoulsilver: Sprites,

    val platinum: Sprites
)

data class Versions (
    @Json(name = "generation-i")
    val generationI: GenerationI,

    @Json(name = "generation-ii")
    val generationIi: GenerationIi,

    @Json(name = "generation-iii")
    val generationIii: GenerationIii,

    @Json(name = "generation-iv")
    val generationIv: GenerationIv,

    @Json(name = "generation-v")
    val generationV: GenerationV,

    @Json(name = "generation-vi")
    val generationVi: Map<String, GenerationVi>,

    @Json(name = "generation-vii")
    val generationVii: GenerationVii,

    @Json(name = "generation-viii")
    val generationViii: GenerationViii
)

data class Sprites (
    @Json(name = "back_default")
    val backDefault: String,

    @Json(name = "back_female")
    val backFemale: Any? = null,

    @Json(name = "back_shiny")
    val backShiny: String,

    @Json(name = "back_shiny_female")
    val backShinyFemale: Any? = null,

    @Json(name = "front_default")
    val frontDefault: String,

    @Json(name = "front_female")
    val frontFemale: Any? = null,

    @Json(name = "front_shiny")
    val frontShiny: String,

    @Json(name = "front_shiny_female")
    val frontShinyFemale: Any? = null,

    val other: Other? = null,
    val versions: Versions? = null,
    val animated: Sprites? = null
)

data class GenerationI (
    @Json(name = "red-blue")
    val redBlue: RedBlue,

    val yellow: RedBlue
)

data class RedBlue (
    @Json(name = "back_default")
    val backDefault: String,

    @Json(name = "back_gray")
    val backGray: String,

    @Json(name = "front_default")
    val frontDefault: String,

    @Json(name = "front_gray")
    val frontGray: String
)

data class GenerationIi (
    val crystal: Crystal,
    val gold: Crystal,
    val silver: Crystal
)

data class Crystal (
    @Json(name = "back_default")
    val backDefault: String,

    @Json(name = "back_shiny")
    val backShiny: String,

    @Json(name = "front_default")
    val frontDefault: String,

    @Json(name = "front_shiny")
    val frontShiny: String
)

data class GenerationIii (
    val emerald: Emerald,

    @Json(name = "firered-leafgreen")
    val fireredLeafgreen: Crystal,

    @Json(name = "ruby-sapphire")
    val rubySapphire: Crystal
)

data class Emerald (
    @Json(name = "front_default")
    val frontDefault: String,

    @Json(name = "front_shiny")
    val frontShiny: String
)

data class GenerationVi (
    @Json(name = "front_default")
    val frontDefault: String,

    @Json(name = "front_female")
    val frontFemale: Any? = null,

    @Json(name = "front_shiny")
    val frontShiny: String,

    @Json(name = "front_shiny_female")
    val frontShinyFemale: Any? = null
)

data class GenerationVii (
    val icons: DreamWorld,

    @Json(name = "ultra-sun-ultra-moon")
    val ultraSunUltraMoon: GenerationVi
)

data class DreamWorld (
    @Json(name = "front_default")
    val frontDefault: String,

    @Json(name = "front_female")
    val frontFemale: Any? = null
)

data class GenerationViii (
    val icons: DreamWorld
)

data class Other (
    @Json(name = "dream_world")
    val dreamWorld: DreamWorld,

    @Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork (
    @Json(name = "front_default")
    val frontDefault: String
)

data class Stat (
    @Json(name = "base_stat")
    val baseStat: Long,

    val effort: Long,
    val stat: NameAndURL
)

data class Type (
    val slot: Long,
    val type: NameAndURL
)