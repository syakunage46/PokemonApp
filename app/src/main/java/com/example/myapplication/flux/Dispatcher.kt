package com.example.myapplication.flux

import kotlinx.coroutines.flow.Flow

interface Dispatcher<ActionType, StateType: State> {
    val actionFlow: Flow<ActionType>
    val alterFlow: Flow<Alter<StateType>>
    fun dispose()
}