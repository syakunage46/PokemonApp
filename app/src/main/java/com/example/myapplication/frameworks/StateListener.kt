package com.example.myapplication.frameworks

import com.example.myapplication.flux.State
import kotlinx.coroutines.flow.Flow

interface StateListenerInterface

class StateListener(stateFlow: Flow<State>): StateListenerInterface