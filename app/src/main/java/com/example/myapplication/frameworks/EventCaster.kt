package com.example.myapplication.frameworks

import com.example.core.event.Event
import com.example.myapplication.interface_adapters.controller.EventReceiverInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

interface EventCasterInterface: EventReceiverInterface {
    val eventFLow: Flow<Event>
}

class EventCaster: EventCasterInterface {
    private val _eventFlow = MutableStateFlow<Event?>(null)
    override val eventFLow: Flow<Event> = _eventFlow.filterNotNull()

    override fun event(event: Event) {
        _eventFlow.value = event
    }
}