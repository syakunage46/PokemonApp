package com.example.myapplication.module.pokemonlist.store

import androidx.lifecycle.*
import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.Store
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class PokemonListStore (private val dispatcher: Dispatcher<*, List<PokemonData>>): Store<List<PokemonData>>(dispatcher) {

    init {
        dispatcher.state.flatMapConcat { state ->
            flow { emit(state.data) }
        }.onEach {
            _pokemonList.postValue(it)
        }.launchIn(viewModelScope)
    }

    private val _pokemonList = MutableLiveData<List<PokemonData>>()
    override val data: LiveData<List<PokemonData>>
        get() = _pokemonList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading
}