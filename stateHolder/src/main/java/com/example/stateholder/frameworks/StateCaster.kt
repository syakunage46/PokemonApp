package com.example.stateholder.frameworks

import com.example.stateholder.entities.State
import com.example.stateholder.interfaseadapters.StateStoreInterFace
import kotlinx.coroutines.flow.StateFlow

interface StateCasterInterFace {
    val stateFLow: StateFlow<State>
}
class StateCaster(private val stateStore: StateStoreInterFace): StateCasterInterFace {
    override val stateFLow: StateFlow<State> = stateStore.stateFLow
}