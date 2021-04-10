package com.example.stateholder.interfaseadapters

import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.State
import com.example.stateholder.usecases.StateRecipient
import kotlinx.coroutines.flow.*

interface StateStoreInterface: StateRecipient {
    val stateFLow: StateFlow<State>
    val state: State
}

internal class StateStore(initialState: State): StateStoreInterface {
    private val _stateFlow = MutableStateFlow(initialState)
    override val stateFLow: StateFlow<State>
        get() = _stateFlow
    override val state: State
        get() = stateFLow.value

    override suspend fun dispatch(alter: Alter) {
        _stateFlow.emit(alter(state))
    }
}