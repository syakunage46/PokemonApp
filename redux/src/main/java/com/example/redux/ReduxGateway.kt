package com.example.redux

import com.example.core.state.State
import com.example.redux.frameworks.EventInputConnector
import com.example.redux.frameworks.EventInputConnectorInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface ReduxGatewayInterface {
    val stateFlow: Flow<State>
    val eventInputConnector: EventInputConnectorInterface
}

class ReduxGateway: ReduxGatewayInterface {
    override val stateFlow: Flow<State> = flowOf(State(emptyMap()))
    override val eventInputConnector: EventInputConnectorInterface = EventInputConnector()
}