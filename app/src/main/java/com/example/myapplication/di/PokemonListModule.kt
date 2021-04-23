package com.example.myapplication.di

import com.example.core.pokemon.PokemonStateElement
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.myapplication.interface_adapters.gateway.ElementStreet
import com.example.myapplication.module.pokemonlist.PokemonListControllerInterface
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListPresenter
import com.example.myapplication.module.pokemonlist.PokemonListPresenterInterface
import com.example.myapplication.module.pokemonlist.view.PokemonListAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PokemonListModule {

    @Singleton
    @Provides
    fun providePokemonListController(eventCaster: EventCasterInterface): PokemonListControllerInterface
            = PokemonListController(eventCaster)

    @Singleton
    @Provides
    fun providePokemonListPresenter(pokemonElementFlow: ElementStreet<PokemonStateElement>): PokemonListPresenterInterface
            = PokemonListPresenter(pokemonElementFlow)

    @Provides
    fun providePokemonListAdapter() = PokemonListAdapter()
}