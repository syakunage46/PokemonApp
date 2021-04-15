package com.example.core.state

import kotlin.reflect.KClass

typealias StateElements = Map<KClass<out StateElement>, StateElement>
typealias MutableStateElements = MutableMap<KClass<out StateElement>, StateElement>

class State(val stateElements: StateElements){
    inline operator fun<reified Key: StateElement> get(key: KClass<Key>):Key? = stateElements[key] as? Key

    fun shift(init: StateBuilder.() -> Unit): State {
        val builder = StateBuilder(stateElements.toMutableMap())
        builder.init()
        return builder.export()
    }
}

class StateBuilder(val mutableStateElement: MutableStateElements){
    fun export(): State = State(mutableStateElement.toMap())

    inline fun<reified T: StateElement> prevOrDefault(default: T): T
        = mutableStateElement[T::class] as? T ?: default

    inline fun <reified T : StateElement> element(element: T) {
        mutableStateElement[T::class] = element
    }
}

data class TestData(val number: Int)
data class TestElement(val text: String): StateElement
data class TestElement2(val testData: TestData): StateElement

fun main() {
    val testElement = TestElement("test")
    val testElement2 = TestElement2(TestData(2))

    val state = State(mapOf(
        TestElement::class to testElement
    ))

    val nextState = state.shift {
        element(prevOrDefault(testElement2).copy(
            testData = TestData(2)
        ))
    }

    nextState.stateElements.forEach {
        val printText = it.value::class.simpleName + ": " + when(val value = it.value){
            is TestElement -> {
                value.text
            }
            is TestElement2 -> {
                value.testData.number.toString()
            }
            else -> {
                it.value.toString()
            }
        }
        println(printText)
    }
}