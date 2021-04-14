package com.example.stateholder.interfaseadapters

import com.example.core.event.Event
import com.example.core.pokemon.PokemonEvent
import com.example.stateholder.usecases.PokemonListActionPlannerInterface

interface EventControllerInterface {
    suspend fun event(event: Event)
}

// 全てのアクションプランナーを持つ必要性がある
internal class EventController(private val pokemonListActionPlanner: PokemonListActionPlannerInterface): EventControllerInterface {
    override suspend fun event(event: Event) {
        pokemonListActionPlanner.startLoading()
        when(event) {
            is PokemonEvent.OnCreate,
            is PokemonEvent.OnSwipeRefresh -> {
                pokemonListActionPlanner.getPokemonList(REQUEST_ITEM_COUNT, 0)
            }
            is PokemonEvent.OnScrolledToEnd -> {
                pokemonListActionPlanner.addPokemonList(REQUEST_ITEM_COUNT, event.offset)
            }
            is PokemonEvent.OnError -> {
                pokemonListActionPlanner.filed(event.throwable)
            }
        }
    }

    companion object {
        const val REQUEST_ITEM_COUNT = 15
    }
}