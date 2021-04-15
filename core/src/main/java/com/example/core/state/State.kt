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