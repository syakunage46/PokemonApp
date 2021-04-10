package com.example.stateholder.entities

import kotlinx.coroutines.flow.Flow

interface ActionCreatorInterFace<EventType, ActionType: Action> {
    val actionFlow: Flow<ActionType>
    operator fun invoke(eventType: EventType)
    fun dispose()
}

//class ActionCreator: ActionCreatorInterFace