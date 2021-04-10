package com.example.myapplication.di

import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Alter
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.gateway.pokemonrepository.PokemonRepositoryUseCases
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListControllerService
import com.example.myapplication.module.pokemonlist.store.*
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

typealias NonWildcardFlow<T> = Flow<@JvmSuppressWildcards T>

@Module
class PokemonListModule {

    @Provides
    fun providePokemonListController(actionCreator: ActionCreator<PokemonListActionType, PokemonListEventType>): PokemonListController
            = PokemonListControllerService(actionCreator)

    @ExperimentalCoroutinesApi
    @Singleton
    @Provides
    fun providePokemonListActionCreator(pokemonRepositoryUseCases: PokemonRepositoryUseCases): ActionCreator<PokemonListActionType, PokemonListEventType>
            = PokemonListActionCreator(pokemonRepositoryUseCases)

    @Singleton
    @Provides
    fun providePokemonListActionFlow(actionCreator: ActionCreator<PokemonListActionType, PokemonListEventType>): NonWildcardFlow<PokemonListActionType>
            = actionCreator.actionFlow

    @Singleton
    @Provides
    fun providePokemonListDispatcher(actionFlow: NonWildcardFlow<PokemonListActionType>): Dispatcher<PokemonListActionType, PokemonListState>
            = PokemonListDispatcher(actionFlow)

    @Singleton
    @Provides
    fun providePokemonListStateFlow(dispatcher: Dispatcher<PokemonListActionType, PokemonListState>): NonWildcardFlow<Alter<PokemonListState>>
            = dispatcher.alterFlow

    @Singleton
    @Provides
    fun providePokemonListStoreFactory(stateFlow: NonWildcardFlow<Alter<PokemonListState>>): PokemonListStoreFactory
            = PokemonListStoreFactory(stateFlow)
}