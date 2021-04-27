package com.example.redux.base_component

interface DispatcherInterface {
    fun dispatch(action: Action)
}

class Dispatcher(private val store: StoreInterface): DispatcherInterface {
    override fun dispatch(action: Action) {
        store.dispatch(action)
    }
}