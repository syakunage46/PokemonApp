package com.example.stateflow

import com.example.core.state.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapNotNull

class Mutator<T: Any>(private val mutate: (T) -> T) {
    operator fun invoke(current: T): T = mutate(current)
}

interface StateShifterInterface {
    val mutationFlow: Flow<Mutator<State>>
}

class StateShifter(private val actionFlow: Flow<Action>): StateShifterInterface {
    override val mutationFlow: Flow<Mutator<State>> = actionFlow.mapNotNull { it as? Mutator<State> }
}