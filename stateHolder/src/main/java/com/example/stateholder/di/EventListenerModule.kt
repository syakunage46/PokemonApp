package com.example.stateholder.di

import com.example.core.event.Event
import com.example.core.util.NonWildcardFlow
import com.example.stateholder.frameworks.EventListener
import com.example.stateholder.frameworks.EventListenerInterface
import com.example.stateholder.interfaseadapters.EventControllerInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventListenerModule {

    @Singleton
    @Provides
    fun provideEventListener(eventFlow: NonWildcardFlow<Event>, controller: EventControllerInterface): EventListenerInterface
            = EventListener(eventFlow, controller)
}