package com.example.redux.frameworks

import com.example.core.event.Event
import com.example.redux.base_component.ActionCreator
import com.example.redux.base_component.ActionCreatorInterface

interface EventInputConnectorInterface {
    fun pass(event: Event)
}

class EventInputConnector(val actionCreator: ActionCreatorInterface): EventInputConnectorInterface {
    override fun pass(event: Event) {
        actionCreator.post(event)
    }
}