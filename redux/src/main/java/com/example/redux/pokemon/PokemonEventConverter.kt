package com.example.redux.pokemon

import com.example.core.event.Event
import com.example.core.pokemon.PokemonEvent
import com.example.redux.base_component.Action
import com.example.redux.base_component.EventConverterInterface
import com.example.redux.navigation.NavigationAction

interface PokemonEventConverterInterface: EventConverterInterface

class PokemonEventConverter: PokemonEventConverterInterface {
    override fun convert(event: Event): Action {
        return when(event) {
            is PokemonEvent.OnCreate,
            is PokemonEvent.OnSwipeRefresh -> PokemonAction.FetchList(REQUEST_ITEM_COUNT,0, event)
            is PokemonEvent.OnScrolledToEnd -> PokemonAction.FetchList(REQUEST_ITEM_COUNT, event.offset, event)
            is PokemonEvent.OnTapToPokemonItem -> NavigationAction.ToPokemonDetail(event.id)
            is PokemonEvent.OnError -> PokemonAction.Failed(event.throwable)
            else -> PokemonAction.Failed(Exception("${this::class.simpleName}は${event::class.simpleName}をActionに変換することができませんでした。"))
        }
    }

    companion object {
        const val REQUEST_ITEM_COUNT = 20
    }
}