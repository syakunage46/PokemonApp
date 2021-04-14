package com.example.appadapter

import android.app.Application
import com.example.appadapter.di.DaggerAppAdapterGatewayComponent
import com.example.core.event.Event
import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface AppAdapterGatewayInterface {
    val stateFlow: Flow<State>
}

class AppAdapterGateway @Inject constructor(
    override val stateFlow: Flow<State>
) : AppAdapterGatewayInterface {
    companion object {
        @Volatile
        private var instance: AppAdapterGatewayInterface? = null

        private fun create(app: Application, eventFlow: Flow<Event>): AppAdapterGatewayInterface {
            return DaggerAppAdapterGatewayComponent.factory().create(app, eventFlow).appAdapterGateway()
        }

        fun getInstance(app: Application, eventFlow: Flow<Event>): AppAdapterGatewayInterface =
            (instance ?: create(app, eventFlow)).also { instance = it }
    }
}