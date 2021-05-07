package com.example.myapplication.di

import androidx.lifecycle.ViewModel
import com.example.myapplication.scene.pokemondetail.PokemonDetailFragment
import com.example.myapplication.scene.pokemonlist.PokemonListFragment
import com.example.myapplication.scene.pokemonlist.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class PokemonListFragmentModule {
    @ContributesAndroidInjector
    abstract fun contributePokemonListFragment(): PokemonListFragment

    @ContributesAndroidInjector
    abstract fun contributePokemonDetailFragment(): PokemonDetailFragment

    @Binds
    @IntoMap
    @ViewModelKey(PokemonListViewModel::class)
    abstract fun bindPokemonListViewModel(viewModel: PokemonListViewModel): ViewModel
}