package com.example.myapplication.di

import com.example.myapplication.scene.pokemonlist.PokemonListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class PokemonListFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributePokemonListFragment(): PokemonListFragment
}