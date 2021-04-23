package com.example.myapplication.di

import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.myapplication.module.pokemonlist.PokemonListControllerInterface
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListPresenter
import com.example.myapplication.module.pokemonlist.PokemonListPresenterInterface
import com.example.myapplication.module.pokemonlist.presenter.PokemonListAdapter
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.mapNotNull
import javax.inject.Singleton

@Module
class PokemonListModule {

    @Singleton
    @Provides
    fun providePokemonListController(eventCaster: EventCasterInterface): PokemonListControllerInterface
            = PokemonListController(eventCaster)

    // TODO とりあえずデバッグ用
    @Singleton
    @Provides
    fun providePokemonStateElementFlow(stateFlow: NonWildcardFlow<State>): NonWildcardFlow<PokemonStateElement>
            = stateFlow.mapNotNull { it[PokemonStateElement::class] }

    @Singleton
    @Provides
    fun providePokemonListPresenter(pokemonStateElementFlow: NonWildcardFlow<PokemonStateElement>): PokemonListPresenterInterface
            = PokemonListPresenter(pokemonStateElementFlow)

    @Provides
    fun providePokemonListAdapter() = PokemonListAdapter()
}