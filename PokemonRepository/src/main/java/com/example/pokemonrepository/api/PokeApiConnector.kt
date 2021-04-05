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
    suspend fun getPokemonListAsync(@Query("limit")limit: Int,@Query("offset")offset: Int): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonAsync(@Path("id") id: Long): PokemonResponse

    @GET("pokemon/{name}")
    suspend fun getPokemonAsync(@Path("name") name: String): PokemonResponse

    @GET("pokemon-species/{id}")
    suspend fun getPokemonSpeciesAsync(@Path("id") id: Long): PokemonSpeciesResponse

    @GET("pokemon-species/{name}")
    suspend fun getPokemonSpeciesAsync(@Path("name") id: String): PokemonSpeciesResponse
}