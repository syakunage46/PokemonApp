package com.example.redux.di

import com.example.redux.base_component.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReduxReducerModule {
    @Singleton
    @Provides
    fun provideReducer(): ReducerInterface = Reducer(elementReducers)

    private val elementReducers: ElementReducers = emptyList()
}