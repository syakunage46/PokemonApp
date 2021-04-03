package com.example.pokemonrepository.api.response

import com.squareup.moshi.Json

data class PokemonListResponse(
    val count: Long,
    @Json(name = "next")
    val nextUrl: String?,
    val previous: String?,
    val results: List<NameAndURL>
)