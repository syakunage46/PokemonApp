package com.example.myapplication.module.pokemonlist.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.Dispatcher
import javax.inject.Inject

class PokemonListStoreFactory @Inject constructor(private val  dispatcher: Dispatcher<*, PokemonStateValue>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListStore::class.java)) {
            return PokemonListStore(dispatcher) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}