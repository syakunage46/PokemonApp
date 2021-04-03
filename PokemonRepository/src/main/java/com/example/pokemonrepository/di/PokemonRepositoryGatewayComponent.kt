package com.example.pokemonrepository.di

import android.app.Application
import com.example.pokemonrepository.PokemonRepositoryGateway
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
    PokemonRepositoryUseCaseBusModule::class
])
interface PokemonRepositoryGatewayComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): PokemonRepositoryGatewayComponent
    }
    fun pokemonRepositoryGateway(): PokemonRepositoryGateway
}