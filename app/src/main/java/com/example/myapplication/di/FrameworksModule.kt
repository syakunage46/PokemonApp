package com.example.myapplication.di

import com.example.appadapter.AppAdapterGatewayInterface
import com.example.core.event.Event
import com.example.core.util.NonWildcardFlow
import com.example.myapplication.frameworks.EventOutputConnector
import com.example.myapplication.frameworks.EventOutputConnectorInterface
import com.example.myapplication.frameworks.StateInputConnector
import com.example.myapplication.frameworks.StateInputConnectorInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FrameworksModule{
    @Singleton
    @Provides
    fun provideEventCaster(): EventOutputConnectorInterface
            = EventOutputConnector()
    @Singleton
    @Provides
    fun provideEventFLow(eventOutputConnector: EventOutputConnectorInterface): NonWildcardFlow<Event>
            = eventOutputConnector.eventFLow
    @Singleton
    @Provides
    fun provideStateListener(appAdapter: AppAdapterGatewayInterface): StateInputConnectorInterface
            = StateInputConnector(appAdapter)
}