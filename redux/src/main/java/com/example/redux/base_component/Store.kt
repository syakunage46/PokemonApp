package com.example.redux.base_component

import com.example.core.state.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface StoreInterface {
    val stateFlow: StateFlow<State>
    fun dispatch(action: Action)
}

class Store(private val reducer: ReducerInterface): StoreInterface {
    private val _stateFlow = MutableStateFlow(State(emptyMap()))
    override val stateFlow = _stateFlow

    override fun dispatch(action: Action) {
        _stateFlow.value = reducer.reduce(stateFlow.value, action)
    }
}