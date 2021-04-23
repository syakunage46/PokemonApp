package com.example.myapplication.interface_adapters.gateway

import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State
import com.example.core.state.StateElement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

interface StateJunctionInterface {
    val pokemonStreet: ElementStreet<PokemonStateElement>
}

class StateJunction(stateFlow: Flow<State>): StateJunctionInterface {
    override val pokemonStreet: ElementStreet<PokemonStateElement>
            = ElementStreet(stateFlow.mapNotNull { it[PokemonStateElement::class] })
}

class ElementStreet<T: StateElement>(private val elementFlow: Flow<T>) {
    operator fun<Value> invoke(sieve :T.() -> Value): Flow<Value> = elementFlow.map { it.sieve() }
}