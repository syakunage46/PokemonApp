package com.example.myapplication.frameworks

import com.example.appadapter.AppAdapterGatewayInterface
import com.example.myapplication.interface_adapters.gateway.StateJunction
import com.example.myapplication.interface_adapters.gateway.StateJunctionInterface

interface StateListenerInterface {
    val stateJunction: StateJunctionInterface
}

class StateListener(appAdapter: AppAdapterGatewayInterface): StateListenerInterface {
    override val stateJunction: StateJunctionInterface = StateJunction(appAdapter.stateFlow)
}