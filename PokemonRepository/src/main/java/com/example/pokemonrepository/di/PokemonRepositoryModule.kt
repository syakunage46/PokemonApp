package com.example.pokemonrepository.di

import com.example.pokemonrepository.repository.PokemonDataSource
import com.example.pokemonrepository.repository.PokemonRepository
import dagger.Module
import dagger.Provides

@Module
class PokemonRepositoryModule  {
    @Provides
    fun providePokemonRepository(pokemonDataSource: PokemonDataSource) = PokemonRepository(pokemonDataSource)
}