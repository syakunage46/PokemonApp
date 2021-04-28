package com.example.redux.base_component

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface StoreInterface {
    val state: StateFlow<State>
    fun dispatch(action: Action)
}

class Store(private val reducerBus: ReducerBusInterface): StoreInterface {
    private val _state = MutableStateFlow(State(emptyMap()))
    override val state = _state

    override fun dispatch(action: Action) {
        _state.value = reducerBus.reduce(state.value, action)
    }
}