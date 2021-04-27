package com.example.redux.base_component

import com.example.core.event.Event

interface ActionAdapterInterface {
    fun convert(event: Event): Action
}