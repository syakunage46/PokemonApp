package com.example.redux.di

import com.example.redux.base_component.ReducerInterface
import com.example.redux.base_component.Store
import com.example.redux.base_component.StoreInterface
import com.example.redux.frameworks.StateOutputConnector
import com.example.redux.frameworks.StateOutputConnectorInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReduxStateModule {
    @Singleton
    @Provides
    fun provideStateOutputConnector(store: StoreInterface): StateOutputConnectorInterface = StateOutputConnector(store)

    @Singleton
    @Provides
    fun provideStore(reducer: ReducerInterface): StoreInterface = Store(reducer)
}
