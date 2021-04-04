package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.State
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

class PokemonListDispatcher(override val actionCreator: ActionCreator<PokemonListActionType, *>,
                            private val dispatcher: CoroutineContext = Dispatchers.Default,
)
    : Dispatcher<PokemonListActionType, List<PokemonData>>{

    private val _state = MutableStateFlow<State<List<PokemonData>>?>(null)
    override val state: Flow<State<List<PokemonData>>> = _state.filterNotNull()

    init {
        CoroutineScope(dispatcher).launch {
            actionCreator.actionFlow.collect {
                when(it) {
                    is PokemonListActionType.LoadSuccess -> {
                        _state.emit(State(it.pokemonDataList))
                    }
                    is PokemonListActionType.Error -> {

                    }
                }
            }
        }
    }
}