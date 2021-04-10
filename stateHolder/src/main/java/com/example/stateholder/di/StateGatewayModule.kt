package com.example.stateholder.di

import com.example.stateholder.StateGateway
import com.example.stateholder.StateGatewayInterface
import com.example.stateholder.frameworks.EventListenerInterface
import com.example.stateholder.frameworks.StateCasterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StateGatewayModule {
    @Singleton
    @Provides
    fun provideStateGateway(eventListener: EventListenerInterface, stateCaster: StateCasterInterface): StateGatewayInterface
            = StateGateway(eventListener, stateCaster)
}