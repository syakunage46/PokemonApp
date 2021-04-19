package com.example.stateflow

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface StateOutputInterface {
    val stateFlow: Flow<State>
}

class StateOutput(override val stateFlow: Flow<State>): StateOutputInterface