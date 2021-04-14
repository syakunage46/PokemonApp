package com.example.appadapter

import android.app.Application
import com.example.appadapter.adapter.EventAdapterInterface
import com.example.appadapter.adapter.StateAdapterInterface
import com.example.appadapter.di.DaggerAppAdapterGatewayComponent
import com.example.myapplication.frameworks.EventCasterInterface
import javax.inject.Inject

interface AppAdapterGatewayInterface {
    val eventAdapter: EventAdapterInterface
    val stateAdapter: StateAdapterInterface
}

class AppAdapterGateway @Inject constructor(
    override val eventAdapter: EventAdapterInterface,
    override val stateAdapter: StateAdapterInterface
) : AppAdapterGatewayInterface {
    companion object {
        @Volatile
        private var instance: AppAdapterGatewayInterface? = null

        private fun create(app: Application, eventCaster: EventCasterInterface): AppAdapterGatewayInterface {
            return DaggerAppAdapterGatewayComponent.factory().create(app, eventCaster).appAdapterGateway()
        }

        fun getInstance(app: Application, eventCaster: EventCasterInterface): AppAdapterGatewayInterface =
            (instance ?: create(app, eventCaster)).also { instance = it }
    }
}