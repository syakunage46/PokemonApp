package com.example.redux.base_component

import com.example.core.state.State
import com.example.core.state.StateElement

interface ElementReducerInterface<ElementType: StateElement> {
    fun reduce(state: State, action: Action): ElementType
}