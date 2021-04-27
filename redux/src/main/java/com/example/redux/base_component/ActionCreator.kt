package com.example.redux.base_component

import com.example.core.event.Event

interface ActionCreatorInterface {
    fun post(event: Event)
}

class ActionCreator<ActionType: Action>(private val actionAdapter: ActionAdapterInterface<ActionType>,
                    private val dispatcher: DispatcherInterface)
    : ActionCreatorInterface {

    override fun post(event: Event) {
        val action = actionAdapter.convert(event)
        dispatcher.dispatch(action)
    }
}