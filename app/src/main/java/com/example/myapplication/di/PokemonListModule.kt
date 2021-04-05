package com.example.myapplication.di

import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.gateway.pokemonrepository.PokemonRepositoryUseCases
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListControllerService
import com.example.myapplication.module.pokemonlist.store.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PokemonListModule {

    @Provides
    fun providePokemonListController(actionCreator: ActionCreator<PokemonListActionType, PokemonListEventType>): PokemonListController
            = PokemonListControllerService(actionCreator)

    @Singleton
    @Provides
    fun providePokemonListActionCreator(pokemonRepositoryUseCases: PokemonRepositoryUseCases): ActionCreator<PokemonListActionType, PokemonListEventType>
            = PokemonListActionCreator(pokemonRepositoryUseCases)

    @Singleton
    @Provides
    fun providePokemonListDispatcher(actionCreator: ActionCreator<PokemonListActionType, PokemonListEventType>): Dispatcher<PokemonListActionType, PokemonListState>
            = PokemonListDispatcher(actionCreator)

    @Singleton
    @Provides
    fun providePokemonListStoreFactory(dispatcher: Dispatcher<PokemonListActionType, PokemonListState>): PokemonListStoreFactory
            = PokemonListStoreFactory(dispatcher)
}