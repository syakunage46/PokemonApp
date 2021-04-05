package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryUseCaseBus
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryUseCases
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
    fun providePokemonExternalRepositoryUseCases(pokemonRepository: PokemonRepository): PokemonExternalRepositoryUseCases
            = PokemonExternalRepositoryUseCaseBus(pokemonRepository)

    @Singleton
    @Provides
    fun providePokemonExternalRepositoryGateway(pokemonExternalRepositoryUseCases: PokemonExternalRepositoryUseCases)
            = PokemonExternalRepositoryGateway(pokemonExternalRepositoryUseCases)
}