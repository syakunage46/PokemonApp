package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryUseCaseBus
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryUseCases
import com.example.pokemonrepository.PokemonRepositoryGateway
import com.example.pokemonrepository.PokemonRepositoryUseCases
import dagger.Module
import dagger.Provides

@Module
class PokemonRepositoryGatewayModule {
    @Provides
    fun providePokemonRepositoryGateway(app: Application): PokemonRepositoryUseCases
            = PokemonRepositoryGateway.getInstance(app)

    @Provides
    fun providePokemonExternalRepositoryUseCases(pokemonRepositoryUseCases: PokemonRepositoryUseCases): PokemonExternalRepositoryUseCases
            = PokemonExternalRepositoryUseCaseBus(pokemonRepositoryUseCases)

    @Provides
    fun providePokemonExternalRepositoryGateway(pokemonExternalRepositoryUseCases: PokemonExternalRepositoryUseCases)
            = PokemonExternalRepositoryGateway(pokemonExternalRepositoryUseCases)
}