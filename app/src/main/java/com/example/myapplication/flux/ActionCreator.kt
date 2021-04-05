package com.example.myapplication.flux

import kotlinx.coroutines.flow.Flow
import kotlin.coroutines.CoroutineContext

interface ActionCreator<ActionType, EventType> {
    val actionFlow: Flow<ActionType>
    operator fun invoke(eventType: EventType)
    fun dispose()
}