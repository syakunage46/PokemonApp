package com.example.redux.base_component

import com.example.core.state.State

interface ReducerInterface {
    fun reduce(state: State, action: Action): State
}