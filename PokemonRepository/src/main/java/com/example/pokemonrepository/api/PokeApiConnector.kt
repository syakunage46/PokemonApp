package com.example.pokemonrepository.api

import com.example.pokemonrepository.api.response.PokemonListResponse
import com.example.pokemonrepository.api.response.PokemonResponse
import com.example.pokemonrepository.api.response.PokemonSpeciesResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiConnector {
    @GET("pokemon")
    fun getPokemonListAsync(@Query("limit")limit: Int,@Query("offset")offset: Int): Deferred<PokemonListResponse>

    @GET("pokemon/{id}")
    fun getPokemonAsync(@Path("id") id: Long): Deferred<PokemonResponse>

    @GET("pokemon/{name}")
    fun getPokemonAsync(@Path("name") name: String): Deferred<PokemonResponse>

    @GET("pokemon-species/{id}")
    fun getPokemonSpeciesAsync(@Path("id") id: Long): Deferred<PokemonSpeciesResponse>
}