package com.example.redux.navigation

import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationStateElement
import com.example.core.state.State
import com.example.redux.annotation.ElementReducer
import com.example.redux.base_component.Action
import com.example.redux.base_component.ElementReducerInterface

@ElementReducer
class NavigationReducer: ElementReducerInterface<NavigationStateElement> {
    override fun reduce(state: State, action: Action): NavigationStateElement {
        val element = state[NavigationStateElement::class] ?: NavigationStateElement(Navigation.PokemonList())
        return when(action) {
            is NavigationAction.ToPokemonDetail -> {
                element.copy(current = Navigation.PokemonDetail(action.id))
            }
            else -> element
        }
    }
}
