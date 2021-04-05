package com.example.pokemonrepository.di

import android.app.Application
import com.example.pokemonrepository.PokemonRepositoryGateway
import com.example.pokemonrepository.repository.PokemonRepository
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    PokeApiConnectorModule::class,
    PokemonApiModule::class,
    PokemonDaoModule::class,
    PokemonDataSourceModule::class,
    PokemonRepositoryModule::class,
    PokemonRepositoryUseCaseModule::class
])
interface PokemonRepositoryGatewayComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): PokemonRepositoryGatewayComponent
    }
    fun pokemonRepository(): PokemonRepository
}