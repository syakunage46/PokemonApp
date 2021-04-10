package com.example.stateholder.di

import com.example.stateholder.frameworks.StateCaster
import com.example.stateholder.frameworks.StateCasterInterface
import com.example.stateholder.interfaseadapters.StateStoreInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StateCasterModule {

    @Singleton
    @Provides
    fun provideStateCaster(stateStore: StateStoreInterface): StateCasterInterface
            = StateCaster(stateStore)
}