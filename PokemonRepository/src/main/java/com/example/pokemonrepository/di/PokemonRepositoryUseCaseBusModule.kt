package com.example.pokemonrepository.di

import com.example.pokemonrepository.PokemonRepositoryUseCaseBus
import com.example.pokemonrepository.repository.PokemonRepository
import dagger.Module
import dagger.Provides

@Module
class PokemonRepositoryUseCaseBusModule  {
    @Provides
    fun providePokemonRepositoryUseCaseBus(repository: PokemonRepository): PokemonRepositoryUseCaseBus =
        PokemonRepositoryUseCaseBus(
            repository
        )
}