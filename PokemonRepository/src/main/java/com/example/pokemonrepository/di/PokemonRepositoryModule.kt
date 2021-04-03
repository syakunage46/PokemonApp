package com.example.pokemonrepository.di

import com.example.pokemonrepository.repository.PokemonRepository
import com.example.pokemonrepository.repository.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.PokemonRepositoryService
import com.example.pokemonrepository.repository.remote.PokemonRemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class PokemonRepositoryModule  {
    @Provides
    fun providePokemonRepository(pokemonLocalDataSource: PokemonLocalDataSource,
                                 pokemonRemoteDataSource: PokemonRemoteDataSource): PokemonRepository
            = PokemonRepositoryService(pokemonLocalDataSource, pokemonRemoteDataSource)
}