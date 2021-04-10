package com.example.stateholder.interfaseadapters

import com.example.stateholder.entities.Action
import com.example.stateholder.usecases.ActionPlannerInterFace
import com.example.stateholder.usecases.PokemonListActionPlanner

interface EventControllerInterFace {
    suspend fun event(event: Event)
}

// 全てのアクションプランナーを持つ必要性がある
internal class EventController(private val pokemonListActionPlanner: PokemonListActionPlanner): EventControllerInterFace {
    override suspend fun event(event: Event) {
        pokemonListActionPlanner.getPokemonList()
    }
}