package com.example.appadapter.di

import com.example.appadapter.adapter.EventAdapter
import com.example.appadapter.adapter.EventAdapterInterface
import com.example.appadapter.adapter.StateAdapter
import com.example.appadapter.adapter.StateAdapterInterface
import com.example.appadapter.converter.EventConverterInterface
import com.example.appadapter.converter.StateConverterInterface
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.stateholder.frameworks.StateCasterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdapterModule {
    @Singleton
    @Provides
    fun provideEventAdapter(eventCaster: EventCasterInterface, eventConverter: EventConverterInterface): EventAdapterInterface = EventAdapter(eventCaster, eventConverter)
    @Singleton
    @Provides
    fun provideStateAdapter(stateCaster: StateCasterInterface, stateConverter: StateConverterInterface): StateAdapterInterface = StateAdapter(stateCaster, stateConverter)

}