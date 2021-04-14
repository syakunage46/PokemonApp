package com.example.myapplication.scene.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.module.pokemonlist.PokemonListPresenterInterface
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class PokemonListViewModelFactory @Inject constructor(private val  presenter: PokemonListPresenterInterface): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListViewModel::class.java)) {
            return PokemonListViewModel(presenter) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}