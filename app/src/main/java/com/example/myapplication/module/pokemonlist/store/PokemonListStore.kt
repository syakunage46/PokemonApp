package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import androidx.lifecycle.*
import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.Store
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListStore (private val dispatcher: Dispatcher<*, List<PokemonData>>): Store<List<PokemonData>>(dispatcher) {

    init {
        viewModelScope.launch {
            dispatcher.state.flatMapConcat { state ->
                flow { emit(state.data) }
            }.collect {
                Log.d("aaaaaaaaaa", "Store: ${it.size}")
                _pokemonList.postValue(it)
            }
        }
    }

    private val _pokemonList = MutableLiveData<List<PokemonData>>()
    override val data: LiveData<List<PokemonData>>
        get() = _pokemonList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading
}