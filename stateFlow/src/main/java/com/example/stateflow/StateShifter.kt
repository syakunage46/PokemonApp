package com.example.stateflow

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class Mutate<T: Any>(private val shift: (T) -> T) {
    operator fun invoke(current: T): T = shift(current)
}

interface StateShifterInterface {
    val mutateFlow: Flow<Mutate<State>>
}

class StateShifter(private val actionFlow: Flow<Action>): StateShifterInterface {
    override val mutateFlow: Flow<Mutate<State>> = actionFlow.mapNotNull { it as? Mutate<State> }
}