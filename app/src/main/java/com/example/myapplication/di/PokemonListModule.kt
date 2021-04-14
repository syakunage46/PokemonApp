package com.example.myapplication.di

import com.example.myapplication.frameworks.EventCasterInterface
import com.example.myapplication.module.pokemonlist.PokemonListControllerInterface
import com.example.myapplication.module.pokemonlist.PokemonListController
import dagger.Module
import dagger.Provides

@Module
class PokemonListModule {

    @Provides
    fun providePokemonListController(eventCaster: EventCasterInterface): PokemonListControllerInterface
            = PokemonListController(eventCaster)

}