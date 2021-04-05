package com.example.pokemonrepository.api.response

import com.squareup.moshi.Json

data class PokemonListResponse(
    val count: Long,
    @Json(name = "next")
    val nextUrl: String?,
    @Json(name = "previous")
    val previousUrl: String?,
    val results: List<NameAndURL>
)