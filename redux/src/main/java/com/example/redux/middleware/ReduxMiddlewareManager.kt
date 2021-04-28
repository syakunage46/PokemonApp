package com.example.redux.middleware

import com.example.redux.base_component.Action
import com.example.redux.base_component.StoreInterface

interface ReduxMiddlewareManagerInterface {
    fun dispatch(store: StoreInterface, action: Action)
}

class ReduxMiddlewareManager(private val middlewareList: List<ReduxMiddleware>): ReduxMiddlewareManagerInterface {
    override fun dispatch(store: StoreInterface, action: Action) {
        val pass: (Action) -> Action = { a -> a }
        val chain = middlewareList.map{ it(store) }.foldRight(pass , { f, composed -> f(composed) })
        val resultAction = chain(action)
        store.dispatch(resultAction)
    }
}