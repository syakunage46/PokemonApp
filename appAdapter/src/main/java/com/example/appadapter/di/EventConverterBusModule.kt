package com.example.appadapter.di

import com.example.appadapter.redux.EventConverterBus
import com.example.appadapter.redux.EventConverters
import com.example.appadapter.repository.RepositoryBus
import com.example.core.pokemon.PokemonEvent
import com.example.core.repository.Repository
import com.example.redux.base_component.EventConverterInterface
import com.example.redux.pokemon.PokemonEventConverter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class EventConverterBusModule {

    @Singleton
    @Provides
    fun provideEventConverterBus(): EventConverterInterface = EventConverterBus(eventConverters)

    //TODO: 綺麗にしたい　EventGroupとか？
    private val eventConverters: EventConverters = mapOf(
        PokemonEvent.OnCreate::class to PokemonEventConverter(),
        PokemonEvent.OnSwipeRefresh::class to PokemonEventConverter(),
        PokemonEvent.OnScrolledToEnd::class to PokemonEventConverter(),
        PokemonEvent.OnError::class to PokemonEventConverter()
    )
}