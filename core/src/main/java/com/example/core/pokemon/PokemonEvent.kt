package com.example.core.pokemon

import com.example.core.event.Event

interface PokemonEvent: Event {
    class OnCreate: PokemonEvent
    class OnSwipeRefresh : PokemonEvent
    class OnScrolledToEnd(val offset: Int) : PokemonEvent
    class OnError(val throwable: Throwable): PokemonEvent
}