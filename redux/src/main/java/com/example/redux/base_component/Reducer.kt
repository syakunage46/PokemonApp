package com.example.redux.base_component

import com.example.core.state.State
import com.example.redux.annotation.Reducer

interface ReducerInterface {
    fun reduce(state: State, action: Action): State
}

typealias ElementReducers = List<ElementReducerInterface<*>>

@Reducer(elementReducerInterface = ElementReducerInterface::class)
class Reducer(private val elementReducers: ElementReducers): ReducerInterface {
    override fun reduce(state: State, action: Action): State {
        return state.shift {
            elementReducers.forEach { elementReducer ->
                element(elementReducer.reduce(state, action))
            }
        }
    }
}