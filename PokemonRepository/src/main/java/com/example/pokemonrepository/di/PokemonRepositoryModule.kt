package com.example.pokemonrepository.di

import com.example.pokemonrepository.repository.PokemonRepository
import com.example.pokemonrepository.repository.datasource.local.PokemonLocalDataSource
import com.example.pokemonrepository.repository.PokemonRepositoryService
import com.example.pokemonrepository.repository.datasource.remote.PokemonRemoteDataSource
import com.example.pokemonrepository.usecase.GetPokemonList
import dagger.Module
import dagger.Provides

@Module
class PokemonRepositoryModule  {
    @Provides
    fun providePokemonRepository(
        getPokemonList: GetPokemonList
    ): PokemonRepository = PokemonRepositoryService(
        getPokemonList
    )
}