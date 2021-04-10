package com.example.stateholder.di

import com.example.stateholder.interfaseadapters.EventController
import com.example.stateholder.interfaseadapters.EventControllerInterface
import com.example.stateholder.usecases.PokemonListActionPlannerInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventControllerModule {

    @Singleton
    @Provides
    fun provideEventController(pokemonListActionPlanner: PokemonListActionPlannerInterface): EventControllerInterface
            = EventController(pokemonListActionPlanner)
}