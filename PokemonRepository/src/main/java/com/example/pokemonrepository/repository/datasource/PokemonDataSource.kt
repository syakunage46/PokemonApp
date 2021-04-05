package com.example.pokemonrepository.repository.datasource

import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.datasource.remote.PokemonRemoteDataSource

interface PokemonDataSource {
    val local: PokemonLocalDataSource
    val remote: PokemonRemoteDataSource
}