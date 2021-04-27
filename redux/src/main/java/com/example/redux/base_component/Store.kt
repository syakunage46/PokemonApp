package com.example.redux.base_component

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface StoreInterface {
    val stateFlow: Flow<State>
    fun dispatch(action: Action)
}

class Store(private val reducerBus: ReducerBusInterface): StoreInterface {
    private val _stateFlow = MutableStateFlow(State(emptyMap()))
    override val stateFlow = _stateFlow

    override fun dispatch(action: Action) {
        TODO("現在のStateとActionからReducerを呼び出してStateを更新")
    }
}