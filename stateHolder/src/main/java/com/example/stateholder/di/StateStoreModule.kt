package com.example.stateholder.di

import com.example.stateholder.entities.AppState
import com.example.stateholder.interfaseadapters.StateStore
import com.example.stateholder.interfaseadapters.StateStoreInterface
import com.example.stateholder.usecases.StateRecipient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StateStoreModule {

    @Singleton
    @Provides
    fun provideStateStore(): StateStoreInterface
            = StateStore(AppState())

    @Singleton
    @Provides
    fun provideStateRecipient(stateStore: StateStoreInterface): StateRecipient
            = stateStore
}