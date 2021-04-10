package com.example.stateholder.usecases

import com.example.stateholder.entities.Action
import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.AlterStateReceiver
import com.example.stateholder.entities.State
import kotlinx.coroutines.flow.Flow

interface StateDispatcherInterFace<ActionType: Action, StateType: State>: AlterStateReceiver {
    val actionFlow: Flow<ActionType>
    val alterFlow: Flow<Alter<StateType>>
    fun dispose()
}

//class StateDispatcher: StateDispatcherInterFace