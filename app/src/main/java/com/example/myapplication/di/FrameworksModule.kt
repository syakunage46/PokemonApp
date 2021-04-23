package com.example.myapplication.di

import com.example.appadapter.AppAdapterGatewayInterface
import com.example.core.event.Event
import com.example.core.state.State
import com.example.core.util.NonWildcardFlow
import com.example.myapplication.frameworks.EventCaster
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.myapplication.frameworks.StateListener
import com.example.myapplication.frameworks.StateListenerInterface
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
class FrameworksModule{
    @Singleton
    @Provides
    fun provideEventCaster(): EventCasterInterface
            = EventCaster()
    @Singleton
    @Provides
    fun provideEventFLow(eventCaster: EventCasterInterface): NonWildcardFlow<Event>
            = eventCaster.eventFLow
    @Singleton
    @Provides
    fun provideStateListener(appAdapter: AppAdapterGatewayInterface): StateListenerInterface
            = StateListener(appAdapter)
}