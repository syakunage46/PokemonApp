package com.example.redux.frameworks

import com.example.core.state.State
import com.example.redux.base_component.StoreInterface
import kotlinx.coroutines.flow.Flow

interface StateOutputConnectorInterface {
    val stateFlow: Flow<State>
}

class StateOutputConnector(store: StoreInterface): StateOutputConnectorInterface {
    override val stateFlow = store.state
}