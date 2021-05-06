package com.example.appadapter.di

import com.example.appadapter.redux.EventConverterBus
import com.example.appadapter.redux.EventConverters
import com.example.appadapter.repository.RepositoryBus
import com.example.core.repository.Repository
import com.example.redux.base_component.EventConverterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventConverterBusModule {

    @Singleton
    @Provides
    fun provideEventConverterBus(): EventConverterInterface = EventConverterBus(eventConverters)

    private val eventConverters: EventConverters = emptyMap()
}