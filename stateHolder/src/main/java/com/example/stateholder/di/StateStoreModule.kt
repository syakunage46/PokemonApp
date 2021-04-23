package com.example.stateholder.di

import com.example.core.state.State
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
            = StateStore(State(emptyMap()))

    @Singleton
    @Provides
    fun provideStateRecipient(stateStore: StateStoreInterface): StateRecipient
            = stateStore
}