package com.example.myapplication.frameworks

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow

interface StateListenerInterface {
    val stateFlow: Flow<State>
}

class StateListener(override val stateFlow: Flow<State>): StateListenerInterface