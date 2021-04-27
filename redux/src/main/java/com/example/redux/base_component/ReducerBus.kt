package com.example.redux.base_component

import com.example.core.state.State
import kotlin.reflect.KClass

typealias Reducers = Map<KClass<out Action>, ReducerInterface<Action>>

interface ReducerBusInterface {
    fun reduce(state: State, action: Action): State
}

class ReducerBus(private val reducers: Reducers): ReducerBusInterface {
    override fun reduce(state: State, action: Action): State {
        return reducers[action::class]?.reduce(state, action) ?: error("ActionTypeに対応するReducerがありません。")
    }
}