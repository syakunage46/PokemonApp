package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.gateway.pokemonrepository.PokemonRepositoryUseCases
import com.example.myapplication.gateway.pokemonrepository.PokemonRepositoryUseCasesService
import com.example.pokemonrepository.PokemonRepositoryGateway
import com.example.pokemonrepository.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PokemonRepositoryGatewayModule {
    @Singleton
    @Provides
    fun providePokemonRepositoryGateway(app: Application): PokemonRepository
            = PokemonRepositoryGateway.getInstance(app)

    @Singleton
    @Provides
    fun providePokemonRepositoryUseCases(pokemonRepository: PokemonRepository): PokemonRepositoryUseCases
            = PokemonRepositoryUseCasesService(pokemonRepository)
}