package com.example.myapplication.frameworks

import com.example.appadapter.AppAdapterGatewayInterface
import com.example.myapplication.interface_adapters.gateway.StateJunction
import com.example.myapplication.interface_adapters.gateway.StateJunctionInterface

interface StateInputConnectorInterface {
    val stateJunction: StateJunctionInterface
}

class StateInputConnector(appAdapter: AppAdapterGatewayInterface): StateInputConnectorInterface {
    override val stateJunction: StateJunctionInterface = StateJunction(appAdapter.stateFlow)
}