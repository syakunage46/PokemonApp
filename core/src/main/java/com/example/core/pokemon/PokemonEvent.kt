package com.example.core.pokemon

import com.example.core.event.Event

sealed class PokemonEvent {
    class OnCreate: Event
    class OnSwipeRefresh : Event
    class OnScrolledToEnd(val offset: Int) : Event
}