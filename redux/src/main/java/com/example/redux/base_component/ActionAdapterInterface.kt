package com.example.redux.base_component

import com.example.core.event.Event

interface ActionAdapterInterface<ActionType: Action> {
    fun convert(event: Event): ActionType
}