package com.example.myapplication.di

import com.example.core.pokemon.PokemonStateElement
import com.example.myapplication.frameworks.StateListenerInterface
import com.example.myapplication.interface_adapters.gateway.ElementStreet
import com.example.myapplication.interface_adapters.gateway.StateJunctionInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StateJunctionModule {

    @Singleton
    @Provides
    fun provideStateJunction(stateListener: StateListenerInterface): StateJunctionInterface
            = stateListener.stateJunction

    @Singleton
    @Provides
    fun providePokemonStreet(stateJunction: StateJunctionInterface): ElementStreet<PokemonStateElement>
            = stateJunction.pokemonStreet
}