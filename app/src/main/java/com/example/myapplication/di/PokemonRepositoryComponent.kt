package com.example.myapplication.di

import com.example.myapplication.scene.pokemonlist.PokemonListStore
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    PokemonRepositoryGatewayModule::class])
interface PokemonRepositoryComponent {
    fun inject(store: PokemonListStore)
}