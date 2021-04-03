package com.example.pokemonrepository.di

import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.db.PokemonDao
import com.example.pokemonrepository.repository.PokemonDataSource
import com.example.pokemonrepository.repository.PokemonDataSourceService
import dagger.Module
import dagger.Provides

@Module
class PokemonDataSourceModule  {
    @Provides
    fun providePokemonDataSource(pokemonDao: PokemonDao, pokemonApi: PokemonApi): PokemonDataSource = PokemonDataSourceService(pokemonDao, pokemonApi)
}