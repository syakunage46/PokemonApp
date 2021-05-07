package com.example.myapplication.module.navigation

import com.example.core.navigation.Navigation
import com.example.core.navigation.NavigationStateElement
import com.example.core.pokemon.PokemonStateElement
import com.example.myapplication.interface_adapters.gateway.ElementStreet
import kotlinx.coroutines.flow.Flow

interface NavigationPresenterInterface {
    val navigationFlow: Flow<Navigation>
}

class NavigationPresenter(navigationStreet: ElementStreet<NavigationStateElement>): NavigationPresenterInterface {
    override val navigationFlow: Flow<Navigation> = navigationStreet{ current }
}