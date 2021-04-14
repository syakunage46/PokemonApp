package com.example.core.state

import kotlin.reflect.KClass

class State(val stateElements: Map<KClass<*>, StateElement>){
    inline operator fun<reified Key: StateElement> get(key: KClass<Key>):Key? = stateElements[key] as? Key
}
