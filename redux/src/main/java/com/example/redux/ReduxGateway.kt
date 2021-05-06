package com.example.redux

import com.example.core.repository.Repository
import com.example.core.state.State
import com.example.redux.base_component.ActionCreatorInterface
import com.example.redux.base_component.EventConverterInterface
import com.example.redux.di.DaggerReduxComponent
import com.example.redux.di.EventConverterModule
import com.example.redux.di.RepositoryModule
import com.example.redux.frameworks.EventInputConnector
import com.example.redux.frameworks.EventInputConnectorInterface
import com.example.redux.frameworks.StateOutputConnectorInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ReduxGatewayInterface {
    val stateFlow: Flow<State>
    val eventInputConnector: EventInputConnectorInterface
}

class ReduxGateway(repository: Repository, eventConverterBus: EventConverterInterface) : ReduxGatewayInterface {
    @Inject lateinit var stateOutputConnector: StateOutputConnectorInterface
    @Inject lateinit var actionCreator: ActionCreatorInterface
    override val stateFlow: Flow<State> = stateOutputConnector.stateFlow
    override val eventInputConnector: EventInputConnectorInterface = EventInputConnector(actionCreator)

    init {
        DaggerReduxComponent.factory().create(RepositoryModule(repository), EventConverterModule(eventConverterBus)).inject(this)
    }
}