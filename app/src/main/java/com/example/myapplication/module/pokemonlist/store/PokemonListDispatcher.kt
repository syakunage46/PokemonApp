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
    : Dispatcher<PokemonListActionType, PokemonStateValue>{

    private val _state = MutableStateFlow<State<PokemonStateValue>?>(null)
    override val state: Flow<State<PokemonStateValue>> = _state.filterNotNull()

    init {
        CoroutineScope(dispatcher).launch {
            actionCreator.actionFlow.collect {
                when(it) {
                    is PokemonListActionType.LoadSuccess -> {
                        val stateValue = PokemonStateValue(it.pokemonDataList, false)
                        _state.emit(State(stateValue))
                    }
                    is PokemonListActionType.InLoading -> {
                        _state.emit(State(PokemonStateValue(null, true)))
                    }
                    is PokemonListActionType.Error -> {

                    }
                }
            }
        }
    }
}