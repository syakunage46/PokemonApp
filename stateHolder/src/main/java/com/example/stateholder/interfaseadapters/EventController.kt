package com.example.stateholder.interfaseadapters

import android.util.Log
import com.example.core.event.Event
import com.example.stateholder.usecases.PokemonListActionPlannerInterface

interface EventControllerInterface {
    suspend fun event(event: Event)
}

// 全てのアクションプランナーを持つ必要性がある
internal class EventController(private val pokemonListActionPlanner: PokemonListActionPlannerInterface): EventControllerInterface {
    override suspend fun event(event: Event) {
        pokemonListActionPlanner.getPokemonList(REQUEST_ITEM_COUNT, 0)
    }

    companion object {
        const val REQUEST_ITEM_COUNT = 15
    }
}