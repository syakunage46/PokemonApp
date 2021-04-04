package com.example.myapplication.module.pokemonlist

import com.example.myapplication.controller.InfiniteScrollListener
import com.example.myapplication.controller.SwipeRefreshDelegate
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.module.pokemonlist.store.PokemonListEventType

interface PokemonListController: SwipeRefreshDelegate {
    fun onCreate()
    fun onScrolledToEnd(offset: Int)
}

class PokemonListControllerService(private val actionCreator: ActionCreator<*, PokemonListEventType>): PokemonListController {
    override fun onCreate() {
        actionCreator(PokemonListEventType.OnCreate())
    }

    override fun onScrolledToEnd(offset: Int) {
        actionCreator(PokemonListEventType.OnScrolledToEnd(offset))
    }

    override fun onSwipeRefresh() {
        actionCreator(PokemonListEventType.OnSwipeRefresh())
    }
}