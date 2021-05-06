package com.example.redux.base_component

import com.example.core.state.State
import com.example.core.state.StateElement
import kotlin.reflect.KClass

interface ReducerInterface {
    fun reduce(state: State, action: Action): State
}

typealias ElementReducers = List<ElementReducerInterface<*>>

class Reducer(private val elementReducers: ElementReducers): ReducerInterface {
    override fun reduce(state: State, action: Action): State {
        return state.shift {
            elementReducers.forEach { elementReducer ->
                element(elementReducer.reduce(state, action))
            }
        }
    }
}