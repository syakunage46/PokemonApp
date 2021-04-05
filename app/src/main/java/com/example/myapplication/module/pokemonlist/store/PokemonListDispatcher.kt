package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Dispatcher
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class PokemonListDispatcher(override val actionCreator: ActionCreator<PokemonListActionType, *>,
                            private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
)
    : Dispatcher<PokemonListActionType, PokemonListState>{

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("PokemonListDispatcher", "例外キャッチ $throwable")
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    private val _state = MutableStateFlow<((PokemonListState) -> PokemonListState)?>(null)
    override val state: Flow<(PokemonListState) -> PokemonListState> = _state.filterNotNull()

    init {
        scope.launch {
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

    override fun dispose() {
        job.cancel()
    }
}