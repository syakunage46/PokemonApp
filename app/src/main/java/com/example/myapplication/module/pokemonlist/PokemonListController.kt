package com.example.myapplication.module.pokemonlist

import com.example.myapplication.controller.SwipeRefreshDelegate
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.module.pokemonlist.store.PokemonListActionType
import com.example.myapplication.module.pokemonlist.store.PokemonListEventType
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

interface PokemonListController: SwipeRefreshDelegate {
    fun onCreate()
}

class PokemonListControllerService(private val actionCreator: ActionCreator<*, PokemonListEventType>): PokemonListController {
    override fun onCreate() {
        actionCreator(PokemonListEventType.onCreate)
    }

    override fun onSwipeRefresh() {
        actionCreator(PokemonListEventType.onSwipeRefresh)
    }
}