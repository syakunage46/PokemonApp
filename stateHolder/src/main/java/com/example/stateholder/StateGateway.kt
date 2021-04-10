package com.example.stateholder

import android.app.Application
import com.example.stateholder.di.DaggerStateGatewayComponent
import com.example.stateholder.di.NonWildcardFlow
import com.example.stateholder.frameworks.EventListenerInterface
import com.example.stateholder.frameworks.StateCasterInterface
import com.example.stateholder.interfaseadapters.Event
import kotlinx.coroutines.flow.Flow

interface StateGatewayInterface {
    val eventListener: EventListenerInterface
    val stateCaster: StateCasterInterface
}

class StateGateway(override val eventListener: EventListenerInterface,
                   override val stateCaster: StateCasterInterface): StateGatewayInterface {
    companion object {
        @Volatile
        private var instance: StateGatewayInterface? = null

        private fun create(app: Application, eventFlow: Flow<Event>): StateGatewayInterface {
            return DaggerStateGatewayComponent.factory().create(app, eventFlow).stateGateway()
        }

        fun getInstance(app: Application, eventFlow: Flow<Event>): StateGatewayInterface =
            (instance ?: create(app, eventFlow)).also { instance = it }
    }
}