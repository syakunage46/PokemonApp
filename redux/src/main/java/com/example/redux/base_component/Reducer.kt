package com.example.redux.base_component

import com.example.core.state.State
import com.example.core.state.StateElement
import kotlin.reflect.KClass

interface ReducerInterface {
    fun reduce(state: State, action: Action): State
}

class Reducer(private val elementReducers: List<ElementReducerInterface<*>>): ReducerInterface {
    override fun reduce(state: State, action: Action): State {
        return state.shift {
            elementReducers.forEach { elementReducer ->
                element(elementReducer.reduce(state, action))
            }
        }
    }
}

data class TestElement(val text: String): StateElement

class TestAction(val text: String): Action

class TestElementReducer: ElementReducerInterface<TestElement> {
    override fun reduce(state: State, action: Action): TestElement {
        println(TestElement::class.hashCode())
        val element = state[TestElement::class] ?: TestElement("default")
        return when(action) {
            is TestAction -> {element.copy(text = action.text)}
            else -> element
        }
    }
}

fun main() {
    val testElement = TestElement("test")

    val testReducer = Reducer(listOf(TestElementReducer()))

    val state = State(mapOf(
            TestElement::class to testElement
    ))

    val action = TestAction("Action!")
    val action2 = TestAction("Action2!")

    val state2 = testReducer.reduce(state, action)
    val nextState = testReducer.reduce(state2, action2)

    println(nextState.stateElements.size)

    nextState.stateElements.forEach {
        val printText = "${it.value::class.simpleName}: " + when(val value = it.value){
            is TestElement -> {
                value.text
            }
            else -> {
                it.value.toString()
            }
        } + ", ${it.value::class.hashCode()}"
        println(printText)
    }

    println(state.hashCode())
    println(nextState.hashCode())
    println(nextState[TestElement::class])
}
