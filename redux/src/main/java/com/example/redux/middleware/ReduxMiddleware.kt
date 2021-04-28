package com.example.redux.middleware

import com.example.redux.base_component.*

typealias ReduxMiddlewareNext = (Action) -> Action
typealias ReduxMiddlewareNextChain = ((Action) -> Action) -> (Action) -> Action

interface ReduxMiddleware {
    operator fun invoke(store: StoreInterface): ReduxMiddlewareNextChain = { next ->
        {action ->
            behavior(store, next, action)
        }
    }
    fun behavior(store: StoreInterface, next: ReduxMiddlewareNext, action: Action): Action
}