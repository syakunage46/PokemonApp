package com.example.appadapter.di

import com.example.core.repository.Repository
import com.example.redux.ReduxGateway
import com.example.redux.ReduxGatewayInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReduxModule {
    @Singleton
    @Provides
    fun provideReduxGateway(repositoryBus: Repository): ReduxGatewayInterface = ReduxGateway(repositoryBus)
}