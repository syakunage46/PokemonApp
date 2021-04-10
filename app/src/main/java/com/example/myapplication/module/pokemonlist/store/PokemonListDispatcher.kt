package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import com.example.myapplication.flux.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class PokemonListDispatcher(override val actionFlow: Flow<PokemonListActionType>,
                            private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
)
    : Dispatcher<PokemonListActionType, PokemonListState>{

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("PokemonListDispatcher", "例外キャッチ $throwable")
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    private val _state = MutableStateFlow<Alter<PokemonListState>?>(null)
    override val alterFlow: Flow<Alter<PokemonListState>> = _state.filterNotNull()

    init {
        scope.launch {
            actionFlow.collect { action ->
                when(action) {
                    is PokemonListActionType.LoadSuccess -> {
                        _state.emit {
                            it.pokemonList = action.pokemonDataList
                            it.isLoading = false
                            it
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
                        _state.emit {
                            it.error = action.error
                            it.isLoading = false
                            return@emit it
                        }
                    }
                }
            }
        }
    }

    override fun dispose() {
        job.cancel()
    }
}