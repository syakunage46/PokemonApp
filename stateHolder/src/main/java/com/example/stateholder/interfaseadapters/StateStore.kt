package com.example.stateholder.interfaseadapters

import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.State
import com.example.stateholder.usecases.StateRecipient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map

internal interface StateStoreInterFace<StateType: State>: StateRecipient {
    val stateFLow: Flow<StateType>
    val state: StateType?
}

internal class StateStore<StateType: State>(initialState: StateType, alterFlow: Flow<Alter<StateType>>): StateStoreInterFace<StateType> {
    private val _stateFlow = alterFlow.map { _state = it(state); return@map state}
    override val stateFLow: Flow<StateType>
        get() = _stateFlow.filterNotNull()

    private var _state: StateType = initialState
    override val state: StateType
        get() = _state
}