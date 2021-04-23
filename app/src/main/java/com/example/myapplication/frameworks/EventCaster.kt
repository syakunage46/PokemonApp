package com.example.myapplication.frameworks

import com.example.core.event.Event
import com.example.myapplication.interface_adapters.controller.EventReceiverInterface
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filterNotNull

interface EventCasterInterface: EventReceiverInterface {
    val eventFLow: Flow<Event>
}

class EventCaster: EventCasterInterface {
    @ExperimentalCoroutinesApi
    private val _eventFlow = BroadcastChannel<Event>(BUFFERED)
    @ExperimentalCoroutinesApi
    @FlowPreview
    override val eventFLow: Flow<Event> = _eventFlow.asFlow()

    @ExperimentalCoroutinesApi
    override fun send(event: Event) {
        _eventFlow.offer(event)
    }
}