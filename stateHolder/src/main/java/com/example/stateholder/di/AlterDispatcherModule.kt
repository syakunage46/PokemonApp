package com.example.stateholder.di

import com.example.stateholder.entities.AlterStateReceiver
import com.example.stateholder.usecases.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AlterDispatcherModule {

    @Singleton
    @Provides
    fun provideStateDispatcher(stateRecipient: StateRecipient): AlterDispatcherInterface
            = AlterDispatcher(stateRecipient)

    @Singleton
    @Provides
    fun provideAlterStateReceiver(alterDispatcher: AlterDispatcherInterface): AlterStateReceiver
            = alterDispatcher
}