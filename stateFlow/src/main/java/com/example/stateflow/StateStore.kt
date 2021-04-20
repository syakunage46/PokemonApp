package com.example.stateflow

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

interface StateStoreInterface {
    val stateFlow: Flow<State>
}

class StateStore(private val mutateFlow: Flow<Mutator<State>>): StateStoreInterface {
    private var state = State(emptyMap())
    override val stateFlow: Flow<State> = mutateFlow.mapNotNull { state = it(state); return@mapNotNull state }
}