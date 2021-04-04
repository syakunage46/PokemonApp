package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import androidx.lifecycle.*
import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.Store
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@FlowPreview
class PokemonListStore (private val dispatcher: Dispatcher<*, PokemonStateValue>): Store<PokemonStateValue>(dispatcher) {

    init {
        viewModelScope.launch {
            dispatcher.state.flatMapConcat { state ->
                flow { emit(state.value) }
            }.collect {
                val nextStateValue = PokemonStateValue(it.pokemonList ?: _state.value?.pokemonList, it.isLoading)
                _state.postValue(nextStateValue)
            }
        }
    }

    private val _state = MutableLiveData<PokemonStateValue>()
    override val state: LiveData<PokemonStateValue>
        get() = _state
}