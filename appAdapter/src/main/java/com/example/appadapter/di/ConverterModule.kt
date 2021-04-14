package com.example.appadapter.di

import com.example.appadapter.converter.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ConverterModule {
    @Singleton
    @Provides
    fun provideEventConverter(): EventConverterInterface
        = EventConverter()
    @Singleton
    @Provides
    fun provideStateConverter(pokemonDataConverter: PokemonDataConverterInterface): StateConverterInterface
            = StateConverter(pokemonDataConverter)
    @Singleton
    @Provides
    fun providePokemonDataConverter(): PokemonDataConverterInterface
            = PokemonDataConverter()

}