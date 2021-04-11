package com.example.myapplication.module.pokemonlist

import com.example.myapplication.controller.SwipeRefreshDelegate

interface PokemonListController: SwipeRefreshDelegate {
    fun onCreate()
    fun onScrolledToEnd(offset: Int)
}

class PokemonListControllerService: PokemonListController {
    override fun onCreate() {

    }

    override fun onScrolledToEnd(offset: Int) {

    }

    override fun onSwipeRefresh() {

    }
}