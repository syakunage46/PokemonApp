package com.example.stateholder.di

import com.example.stateholder.entities.Alter
import com.example.stateholder.usecases.*
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
class StateDispatcherModule {

    @Singleton
    @Provides
    fun provideStateDispatcher(alterFlow: NonWildcardFlow<Alter>, stateRecipient: StateRecipient): StateDispatcherInterface
            = StateDispatcher(alterFlow, stateRecipient)
}