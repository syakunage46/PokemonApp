package com.example.stateholder.interfaseadapters

import com.example.stateholder.usecases.PokemonListActionPlannerInterface

interface EventControllerInterface {
    suspend fun event(event: Event)
}

// 全てのアクションプランナーを持つ必要性がある
internal class EventController(private val pokemonListActionPlanner: PokemonListActionPlannerInterface): EventControllerInterface {
    override suspend fun event(event: Event) {
        pokemonListActionPlanner.getPokemonList(10, 0)
    }
}