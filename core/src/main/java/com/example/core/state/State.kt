package com.example.core.state

import com.example.core.state.State.Builder.state
import kotlin.reflect.KClass

data class State(private val stateElements: MutableMap<KClass<*>, StateElement> = e){
    inline operator fun<reified Key: StateElement> get(key: KClass<Key>):Key? = stateElements[key] as? Key

    companion object Builder {
        fun state(init: State.() -> Unit): State {
            val state = State()
            state.init()
            return state
        }
    }

    inline fun <reified T : StateElement> element(init: T.() -> Unit): T? {
        var element = stateElements[T::class] as? T
        element?.init()
        stateElements[T::class] = element
        return element
    }
}

class TestElement(var text: String): StateElement

fun main() {
    val testElement = TestElement("test")
    val state = State(mapOf(TestElement::class to testElement))

    val nextState = state {
        element<TestElement> {
            text = "test over ride"
        }
    }

    print(nextState)
}