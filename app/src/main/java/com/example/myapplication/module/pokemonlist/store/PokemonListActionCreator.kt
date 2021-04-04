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

    private suspend fun getPokemonList() {
        _actionFlow.emit(PokemonListActionType.InLoading())
        val pokemonDataList = repositoryGateway.getPokemonList(10)
        val action = PokemonListActionType.LoadSuccess(pokemonDataList)
        _actionFlow.emit(action)
    }

    override operator fun invoke(eventType: PokemonListEventType) {
        CoroutineScope(dispatcher).launch {
            getPokemonList()
        }
    }
}