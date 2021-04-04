package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class PokemonListActionCreator(private val repositoryGateway: PokemonExternalRepositoryGateway,
                               private val dispatcher: CoroutineDispatcher = Dispatchers.Default)
    : ActionCreator<PokemonListActionType, PokemonListEventType>{

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
        CoroutineScope(dispatcher).launch {
            when(eventType){
                is PokemonListEventType.OnScrolledToEnd -> {
                    appendPokemonList(offset = eventType.offset)
                }
                is PokemonListEventType.OnSwipeRefresh -> {
                }
                else -> {
                    getPokemonList()
                }
            }
        }
    }

    companion object {
        const val REQUEST_ITEM_COUNT = 10
    }
}