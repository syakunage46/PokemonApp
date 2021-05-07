package com.example.redux.navigation

import com.example.redux.base_component.Action

interface NavigationAction: Action {
    class ToPokemonDetail(val id: Long): NavigationAction
}