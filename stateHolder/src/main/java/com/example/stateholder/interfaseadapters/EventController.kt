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
        Log.d("EventController", "event: $event")
        pokemonListActionPlanner.getPokemonList(10, 0)
    }
}