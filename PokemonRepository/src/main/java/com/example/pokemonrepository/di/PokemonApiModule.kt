package com.example.pokemonrepository.di

import com.example.pokemonrepository.api.PokeApiConnector
import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.api.PokemonApiService
import dagger.Module
import dagger.Provides

@Module
class PokemonApiModule  {

    @Provides
    fun providePokemonApi(pokeApiConnector: PokeApiConnector): PokemonApi = PokemonApiService(pokeApiConnector)
}