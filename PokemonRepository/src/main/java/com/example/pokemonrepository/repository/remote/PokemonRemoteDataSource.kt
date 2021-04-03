package com.example.pokemonrepository.repository.remote

import com.example.pokemonrepository.data.PokemonProperty

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(limit: Int): List<PokemonProperty>
}