package com.example.stateholder.di

import com.example.stateholder.frameworks.EventListener
import com.example.stateholder.frameworks.EventListenerInterface
import com.example.stateholder.interfaseadapters.Event
import com.example.stateholder.interfaseadapters.EventControllerInterface
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
class EventListenerModule {

    @Singleton
    @Provides
    fun provideEventListener(eventFlow: NonWildcardFlow<Event>, controller: EventControllerInterface): EventListenerInterface
            = EventListener(eventFlow, controller)
}