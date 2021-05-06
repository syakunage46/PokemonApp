package com.example.appadapter.di

import com.example.core.repository.Repository
import com.example.redux.ReduxGateway
import com.example.redux.ReduxGatewayInterface
import com.example.redux.base_component.EventConverterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReduxModule {
    @Singleton
    @Provides
    fun provideReduxGateway(repositoryBus: Repository, eventConverterBus: EventConverterInterface): ReduxGatewayInterface = ReduxGateway(repositoryBus, eventConverterBus)
}