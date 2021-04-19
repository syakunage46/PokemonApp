package com.example.stateflow

import com.example.core.event.Event
import kotlinx.coroutines.flow.Flow

interface EventInputInterface {
    val eventFlow: Flow<Event>
}

class EventInput(override val eventFlow: Flow<Event>): EventInputInterface