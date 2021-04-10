package com.example.myapplication.module.pokemonlist.store

import androidx.lifecycle.*
import com.example.myapplication.flux.Alter
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.Store
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@FlowPreview
class PokemonListStore (private val stateFlow: Flow<Alter<PokemonListState>>): Store<PokemonListState>(stateFlow) {

    init {
        viewModelScope.launch {
            stateFlow.collect {
                val nextStateValue = it(state.value ?: PokemonListState(null, false, null))
                _state.postValue(nextStateValue)
            }
        }
    }

    private val _state = MutableLiveData<PokemonListState>()
    override val state: LiveData<PokemonListState>
        get() = _state
}