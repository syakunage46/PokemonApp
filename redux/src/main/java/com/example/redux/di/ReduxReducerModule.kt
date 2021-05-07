package com.example.redux.di

import com.example.redux.base_component.*
import com.example.redux.navigation.NavigationReducer
import com.example.redux.pokemon.PokemonReducer
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReduxReducerModule {
    @Singleton
    @Provides
    fun provideReducer(): ReducerInterface = Reducer(elementReducers)

    private val elementReducers: ElementReducers = listOf(
        PokemonReducer(),
        NavigationReducer()
    )
}