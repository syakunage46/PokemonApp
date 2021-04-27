package com.example.redux.base_component

import com.example.core.state.State

interface ReducerInterface<ActionType: Action> {
    fun reduce(state: State, action: ActionType): State
}