package com.example.pokemonrepository.di

import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.db.PokemonDao
import com.example.pokemonrepository.repository.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.local.PokemonLocalDataSourceService
import com.example.pokemonrepository.repository.remote.PokemonRemoteDataSource
import com.example.pokemonrepository.repository.remote.PokemonRemoteDataSourceService
import dagger.Module
import dagger.Provides

@Module
class PokemonDataSourceModule  {
    @Provides
    fun providePokemonLocalDataSource(pokemonDao: PokemonDao): PokemonLocalDataSource = PokemonLocalDataSourceService(pokemonDao)

    @Provides
    fun providePokemonRemoteDataSource(pokemonApi: PokemonApi): PokemonRemoteDataSource = PokemonRemoteDataSourceService(pokemonApi)
}