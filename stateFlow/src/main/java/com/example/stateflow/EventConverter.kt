package com.example.stateflow

import com.example.core.event.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

interface EventConverterInterface {
    val actionFlow: Flow<Action>
}

class EventConverter(private val eventFlow: Flow<Event>) : EventConverterInterface {
    override val actionFlow: Flow<Action> = eventFlow.mapNotNull { it as? Action }
}