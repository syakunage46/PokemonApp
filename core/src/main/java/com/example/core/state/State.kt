package com.example.core.state

import kotlin.reflect.KClass

data class State(val stateElements: Map<KClass<*>, StateElement> = emptyMap()){
    inline operator fun<reified Key: StateElement> get(key: KClass<Key>):Key? = stateElements[key] as? Key
}
