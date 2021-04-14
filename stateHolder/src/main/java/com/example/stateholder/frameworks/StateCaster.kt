package com.example.stateholder.frameworks

import com.example.core.state.State
import com.example.stateholder.interfaseadapters.StateStoreInterface
import kotlinx.coroutines.flow.StateFlow

interface StateCasterInterface {
    val stateFLow: StateFlow<State>
}
class StateCaster(private val stateStore: StateStoreInterface): StateCasterInterface {
    override val stateFLow: StateFlow<State> = stateStore.stateFLow
}