package com.example.appadapter.adapter

import com.example.appadapter.converter.EventConverterInterface
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.stateholder.interfaseadapters.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface EventAdapterInterface {
    val eventFlow: Flow<Event>
}

class EventAdapter(private val eventCaster: EventCasterInterface, private val eventConverter: EventConverterInterface): EventAdapterInterface {
    override val eventFlow: Flow<Event>
            = eventCaster.eventFLow.map { eventConverter(it) }
}