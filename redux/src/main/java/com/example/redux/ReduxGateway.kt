package com.example.redux

import com.example.core.state.State
import com.example.redux.frameworks.EventInputConnector
import com.example.redux.frameworks.EventInputConnectorInterface
import com.example.redux.frameworks.StateOutputConnectorInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface ReduxGatewayInterface {
    val stateFlow: Flow<State>
    val eventInputConnector: EventInputConnectorInterface
}

class ReduxGateway @Inject constructor(stateOutputConnector: StateOutputConnectorInterface): ReduxGatewayInterface {
    override val stateFlow: Flow<State> = stateOutputConnector.stateFlow
    override val eventInputConnector: EventInputConnectorInterface = EventInputConnector()
}