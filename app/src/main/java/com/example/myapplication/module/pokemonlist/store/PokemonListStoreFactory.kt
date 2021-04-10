package com.example.myapplication.module.pokemonlist.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.flux.Alter
import com.example.myapplication.flux.Dispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonListStoreFactory @Inject constructor(private val  alterFlow: Flow<Alter<PokemonListState>>): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PokemonListStore::class.java)) {
            return PokemonListStore(alterFlow) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}