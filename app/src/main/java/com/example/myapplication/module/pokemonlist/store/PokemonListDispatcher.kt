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

    private val _state = MutableStateFlow<((PokemonListState) -> PokemonListState)?>(null)
    override val state: Flow<(PokemonListState) -> PokemonListState> = _state.filterNotNull()

    init {
        CoroutineScope(dispatcher).launch {
            actionCreator.actionFlow.collect { action ->
                when(action) {
                    is PokemonListActionType.LoadSuccess -> {
                        _state.emit {
                            it.pokemonList = action.pokemonDataList
                            it.isLoading = false
                            return@emit it
                        }
                    }
                    is PokemonListActionType.AdditionalLoadSuccess -> {
                        _state.emit {
                            it.pokemonList = it.pokemonList?.plus(action.pokemonDataList)
                            it.isLoading = false
                            return@emit it
                        }
                    }
                    is PokemonListActionType.InLoading -> {
                        _state.emit {
                            it.isLoading = true
                            return@emit it
                        }
                    }
                    is PokemonListActionType.Error -> {

                    }
                }
            }
        }
    }
}