package com.example.myapplication.flux

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.module.pokemonlist.store.PokemonListState
import kotlinx.coroutines.flow.Flow

abstract class Store<StateType: State>(private val alterFlow: Flow<Alter<StateType>>): ViewModel() {
    abstract val state: LiveData<StateType>
}