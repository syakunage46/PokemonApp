package com.example.myapplication.module.pokemonlist

import com.example.core.pokemon.PokemonEvent
import com.example.myapplication.interface_adapters.controller.SwipeRefreshDelegate
import com.example.myapplication.frameworks.EventCasterInterface

interface PokemonListControllerInterface: SwipeRefreshDelegate {
    fun onCreate()
    fun onScrolledToEnd(offset: Int)
}

class PokemonListController(private val eventCaster: EventCasterInterface): PokemonListControllerInterface {
    override fun onCreate() {
        eventCaster.event(PokemonEvent.OnCreate())
    }

    override fun onScrolledToEnd(offset: Int) {
        eventCaster.event(PokemonEvent.OnScrolledToEnd(offset))
    }

    override fun onSwipeRefresh() {
        eventCaster.event(PokemonEvent.OnSwipeRefresh())
    }
}