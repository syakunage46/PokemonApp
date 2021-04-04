package com.example.myapplication.di

import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListControllerService
import com.example.myapplication.module.pokemonlist.store.*
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@Module
class PokemonListModule {

    @Provides
    fun providePokemonListController(actionCreator: ActionCreator<PokemonListActionType, PokemonListEventType>): PokemonListController
            = PokemonListControllerService(actionCreator)

    @Provides
    fun providePokemonListActionCreator(repositoryGateway: PokemonExternalRepositoryGateway): ActionCreator<PokemonListActionType, PokemonListEventType>
            = PokemonListActionCreator(repositoryGateway)

    @InternalCoroutinesApi
    @Provides
    fun providePokemonListDispatcher(actionCreator: ActionCreator<PokemonListActionType, PokemonListEventType>): Dispatcher<PokemonListActionType, List<PokemonData>>
            = PokemonListDispatcher(actionCreator)

    @Provides
    fun providePokemonListStoreFactory(dispatcher: Dispatcher<PokemonListActionType, List<PokemonData>>): PokemonListStoreFactory
            = PokemonListStoreFactory(dispatcher)
}