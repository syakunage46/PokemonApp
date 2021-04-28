package com.example.redux.base_component

import com.example.redux.middleware.ReduxMiddlewareManagerInterface

interface DispatcherInterface {
    fun dispatch(action: Action)
}

class Dispatcher(private val store: StoreInterface, private val middlewareManager: ReduxMiddlewareManagerInterface): DispatcherInterface {
    override fun dispatch(action: Action) {
        middlewareManager.dispatch(store, action)
    }
}