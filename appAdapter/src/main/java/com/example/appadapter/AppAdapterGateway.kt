package com.example.appadapter

import android.app.Application
import com.example.appadapter.di.DaggerAppAdapterGatewayComponent
import com.example.core.event.Event
import com.example.core.state.State
import com.example.redux.ReduxGatewayInterface
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface AppAdapterGatewayInterface {
    val stateFlow: Flow<State>
    fun send(event: Event)
}

class AppAdapterGateway(app: Application) : AppAdapterGatewayInterface {
    @Inject
    lateinit var reduxGateway: ReduxGatewayInterface

    override lateinit var stateFlow: Flow<State>

    init {
        DaggerAppAdapterGatewayComponent.factory().create(app).inject(this)
        stateFlow = reduxGateway.stateFlow
    }

    override fun send(event: Event) {
        reduxGateway.eventInputConnector.pass(event)
    }
}