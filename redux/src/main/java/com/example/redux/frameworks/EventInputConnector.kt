package com.example.redux.frameworks

import com.example.core.event.Event

interface EventInputConnectorInterface {
    fun pass(event: Event)
}

class EventInputConnector: EventInputConnectorInterface {
    override fun pass(event: Event) {
        println("EventInputConnector $event")
    }
}