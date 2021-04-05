package com.example.pokemonrepository.repository.datasource

import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.datasource.remote.PokemonRemoteDataSource

class PokemonDataSourceService(
    override val local: PokemonLocalDataSource,
    override val remote: PokemonRemoteDataSource
) : PokemonDataSource