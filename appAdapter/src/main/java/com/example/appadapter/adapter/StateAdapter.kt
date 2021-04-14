package com.example.appadapter.adapter

import com.example.appadapter.converter.StateConverterInterface
import com.example.myapplication.flux.State
import com.example.stateholder.frameworks.StateCasterInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface StateAdapterInterface {
    val stateFlow: Flow<State>
}

class StateAdapter(private val stateCaster: StateCasterInterface, private val stateConverter: StateConverterInterface) : StateAdapterInterface {
    override val stateFlow: Flow<State>
            = stateCaster.stateFLow.map { stateConverter(it) }
}