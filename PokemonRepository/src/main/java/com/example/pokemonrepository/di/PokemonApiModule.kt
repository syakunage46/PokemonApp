package com.example.pokemonrepository.di

import com.example.pokemonrepository.api.*
import dagger.Module
import dagger.Provides

@Module
class PokemonApiModule  {

    @Provides
    fun providePokemonApi(pokemonApiUseCases: PokemonApiUseCases): PokemonApi = PokemonApiService(pokemonApiUseCases)

    @Provides
    fun providePokemonApiUseCases(pokeApiConnector: PokeApiConnector): PokemonApiUseCases = PokemonApiUseCaseBus(pokeApiConnector)
}