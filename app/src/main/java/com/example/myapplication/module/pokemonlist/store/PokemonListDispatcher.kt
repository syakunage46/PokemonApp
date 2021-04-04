package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.State
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

class PokemonListDispatcher(override val actionCreator: ActionCreator<PokemonListActionType, *>,
                            private val dispatcher: CoroutineContext = Dispatchers.Default,
)
    : Dispatcher<PokemonListActionType, PokemonListState>{

    private val _state = MutableStateFlow<PokemonListState?>(null)
    override val state: Flow<(PokemonListState)> = _state.filterNotNull()

    init {
        CoroutineScope(dispatcher).launch {
            actionCreator.actionFlow.collect {
                when(it) {
                    is PokemonListActionType.LoadSuccess -> {
                        val state = PokemonListState(it.pokemonDataList, false)
                        _state.emit(state)
                    }
                    is PokemonListActionType.InLoading -> {
                        _state.emit(PokemonListState(null, true))
                    }
                    is PokemonListActionType.Error -> {

                    }
                }
            }
        }
    }
}