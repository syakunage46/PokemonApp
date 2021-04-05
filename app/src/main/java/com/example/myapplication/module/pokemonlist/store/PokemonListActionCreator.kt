package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class PokemonListActionCreator(private val repositoryGateway: PokemonExternalRepositoryGateway,
                               private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default)
    : ActionCreator<PokemonListActionType, PokemonListEventType>{

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e("PokemonListActionCreator", "例外キャッチ $throwable")
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    private val _actionFlow = MutableStateFlow<PokemonListActionType?>(null)
    override val actionFlow: Flow<PokemonListActionType> = _actionFlow.filterNotNull()

    private suspend fun getPokemonList(offset: Int = 0) {
        _actionFlow.emit(PokemonListActionType.InLoading())
        val pokemonDataList = repositoryGateway.getPokemonList(REQUEST_ITEM_COUNT, offset)
        val action = PokemonListActionType.LoadSuccess(pokemonDataList)
        _actionFlow.emit(action)
    }

    private suspend fun appendPokemonList(offset: Int) {
        _actionFlow.emit(PokemonListActionType.InLoading())
        val pokemonDataList = repositoryGateway.getPokemonList(REQUEST_ITEM_COUNT, offset)
        val action = PokemonListActionType.AdditionalLoadSuccess(pokemonDataList)
        _actionFlow.emit(action)
    }

    override operator fun invoke(eventType: PokemonListEventType) {
        scope.launch {
            when(eventType){
                is PokemonListEventType.OnScrolledToEnd -> {
                    appendPokemonList(offset = eventType.offset)
                }
                else -> {
                    getPokemonList()
                }
            }
        }
    }

    override fun dispose() {
       job.cancel()
    }

    companion object {
        const val REQUEST_ITEM_COUNT = 10
    }
}