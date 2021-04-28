package com.example.redux.base_component

import com.example.core.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface StoreInterface {
    val state: StateFlow<State>
    fun dispatch(action: Action)
}

class Store(private val reducer: ReducerInterface): StoreInterface {
    private val _state = MutableStateFlow(State(emptyMap()))
    override val state = _state

    override fun dispatch(action: Action) {
        _state.value = reducer.reduce(state.value, action)
    }
}