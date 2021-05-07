package com.example.myapplication.module.pokemonlist

import com.example.core.pokemon.PokemonEvent
import com.example.myapplication.interface_adapters.controller.SwipeRefreshDelegate
import com.example.myapplication.frameworks.EventOutputConnectorInterface

interface PokemonListControllerInterface: SwipeRefreshDelegate {
    fun onCreate()
    fun onScrolledToEnd(offset: Int)
    fun onTapToPokemonItem(id: Long)
}

class PokemonListController(private val eventOutputConnector: EventOutputConnectorInterface): PokemonListControllerInterface {
    override fun onCreate() {
        eventOutputConnector.send(PokemonEvent.OnCreate())
    }

    override fun onScrolledToEnd(offset: Int) {
        eventOutputConnector.send(PokemonEvent.OnScrolledToEnd(offset))
    }

    override fun onTapToPokemonItem(id: Long) {
        eventOutputConnector.send(PokemonEvent.OnTapToPokemonItem(id))
    }

    override fun onSwipeRefresh() {
        eventOutputConnector.send(PokemonEvent.OnSwipeRefresh())
    }
}