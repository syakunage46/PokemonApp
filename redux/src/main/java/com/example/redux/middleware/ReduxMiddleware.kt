package com.example.redux.middleware

import com.example.core.state.State
import com.example.core.state.StateElement
import com.example.redux.base_component.*

typealias ReduxMiddlewareNext = (Action) -> Action
typealias ReduxMiddlewareNextChain = ((Action) -> Action) -> (Action) -> Action

interface ReduxMiddleware {
    operator fun invoke(store: StoreInterface): ReduxMiddlewareNextChain = { next ->
        {action ->
            behavior(store, next, action)
        }
    }
    fun behavior(store: StoreInterface, next: (Action) -> Action, action: Action): Action
}

data class TestElement(val text: String): StateElement

class TestAction(val text: String): Action

class TestElementReducer: ElementReducerInterface<TestElement> {
    override fun reduce(state: State, action: Action): TestElement {
        println("TestElementReducer")
        val element = state[TestElement::class] ?: TestElement("default")
        return when(action) {
            is TestAction -> {element.copy(text = action.text)}
            else -> element
        }
    }
}


val testMiddleware1 = object: ReduxMiddleware {
    override fun behavior(store: StoreInterface, next: ReduxMiddlewareNext, action: Action): Action {
        println("testMiddleware1")
        val result = if (action is TestAction) { TestAction("${action.text} + Middleware") } else action
        return next(result)
    }
}

val testMiddleware2 = object: ReduxMiddleware {
    override fun behavior(store: StoreInterface, next: ReduxMiddlewareNext, action: Action): Action {
        println("testMiddleware2 - nextを呼び出さない")
        return action
    }
}

val testMiddleware3 = object: ReduxMiddleware {
    override fun behavior(store: StoreInterface, next: ReduxMiddlewareNext, action: Action): Action {
        println("testMiddleware3 2でネクストがコールされないから表示されない")
        return action
    }
}

fun main() {
    val testReducer = Reducer(listOf(TestElementReducer()))
    val action = TestAction("Action!")
    val manager = ReduxMiddlewareManager(listOf(testMiddleware1, testMiddleware2, testMiddleware3))
    val store = Store(testReducer)
    manager.dispatch(store, action)

    store.stateFlow.value.stateElements.forEach {
        println(it.value)
    }
}
