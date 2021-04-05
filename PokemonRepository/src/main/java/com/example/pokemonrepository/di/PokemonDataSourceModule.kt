package com.example.pokemonrepository.di

import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.db.PokemonDao
import com.example.pokemonrepository.repository.datasource.PokemonDataSource
import com.example.pokemonrepository.repository.datasource.PokemonDataSourceService
import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSourceService
import com.example.pokemonrepository.repository.datasource.remote.PokemonRemoteDataSource
import com.example.pokemonrepository.repository.datasource.remote.PokemonRemoteDataSourceService
import dagger.Module
import dagger.Provides

@Module
class PokemonDataSourceModule  {
    @Provides
    fun providePokemonLocalDataSource(pokemonDao: PokemonDao): PokemonLocalDataSource = PokemonLocalDataSourceService(pokemonDao)

    @Provides
    fun providePokemonRemoteDataSource(pokemonApi: PokemonApi): PokemonRemoteDataSource = PokemonRemoteDataSourceService(pokemonApi)

    @Provides
    fun providePokemonDataSource(local: PokemonLocalDataSource, remote: PokemonRemoteDataSource): PokemonDataSource = PokemonDataSourceService(local,remote)
}