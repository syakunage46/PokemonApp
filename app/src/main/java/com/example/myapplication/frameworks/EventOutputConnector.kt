package com.example.myapplication.frameworks

import com.example.appadapter.AppAdapterGatewayInterface
import com.example.core.event.Event
import com.example.myapplication.interface_adapters.controller.EventReceiverInterface
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel.Factory.BUFFERED
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

interface EventOutputConnectorInterface: EventReceiverInterface

class EventOutputConnector(private val appAdapterGateway: AppAdapterGatewayInterface): EventOutputConnectorInterface {
    override fun send(event: Event) {
        appAdapterGateway.send(event)
    }
}