package com.example.pokemonrepository.di

import com.example.pokemonrepository.repository.datasource.PokemonDataSource
import com.example.pokemonrepository.usecase.GetPokemonList
import com.example.pokemonrepository.usecase.GetPokemonListInteractor
import dagger.Module
import dagger.Provides

@Module
class PokemonRepositoryUseCaseModule {
    @Provides
    fun provideGetPokemonList(pokemonDataSource : PokemonDataSource): GetPokemonList = GetPokemonListInteractor(pokemonDataSource)
}