package com.example.myapplication.module.pokemonlist.store

import androidx.lifecycle.*
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.Store
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
class PokemonListStore (private val dispatcher: Dispatcher<*, PokemonListState>): Store<PokemonListState>(dispatcher) {

    init {
        viewModelScope.launch {
            dispatcher.state.collect {
                val nextStateValue = PokemonListState(it.pokemonList ?: _state.value?.pokemonList, it.isLoading)
                _state.postValue(nextStateValue)
            }
        }
    }

    private val _state = MutableLiveData<PokemonListState>()
    override val state: LiveData<PokemonListState>
        get() = _state
}