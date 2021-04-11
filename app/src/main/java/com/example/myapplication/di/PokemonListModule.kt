package com.example.myapplication.di

import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListControllerService
import dagger.Module
import dagger.Provides

@Module
class PokemonListModule {

    @Provides
    fun providePokemonListController(): PokemonListController
            = PokemonListControllerService()

}