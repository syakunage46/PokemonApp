package com.example.appadapter

import com.example.myapplication.flux.State
import com.example.stateholder.frameworks.StateCasterInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//interface StateAdapterInterface {
//    val stateCaster: StateCasterInterface
//    val stateFlow: Flow<State>
//}
//
//class StateAdapter(
//    override val stateCaster: StateCasterInterface,
//) : StateAdapterInterface {
//    override val stateFlow: Flow<State> = stateCaster.stateFLow.map {
//        it as State
//    }
//}