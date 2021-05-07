package com.example.redux.navigation

import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationStateElement
import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State
import com.example.redux.base_component.Action
import com.example.redux.base_component.ElementReducerInterface
import com.example.redux.pokemon.PokemonAction

class NavigationReducer: ElementReducerInterface<NavigationStateElement> {
    override fun reduce(state: State, action: Action): NavigationStateElement {
        val element = state[NavigationStateElement::class] ?: NavigationStateElement(Navigation.PokemonList())
        println("aaaaaaaaaa: $element $action")
        return when(action) {
            is NavigationAction.ToPokemonDetail -> {
                element.copy(current = Navigation.PokemonDetail(action.id))
            }
            else -> element
        }
    }
}
