package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlin.coroutines.CoroutineContext

class PokemonListActionCreator(private val repositoryGateway: PokemonExternalRepositoryGateway,
                               private val dispatcher: CoroutineDispatcher = Dispatchers.Default)
    : ActionCreator<PokemonListActionType, PokemonListEventType>{

    private val _actionFlow = MutableStateFlow<PokemonListActionType?>(null)
    override val actionFlow: Flow<PokemonListActionType>
        get() = _actionFlow.filterNotNull()

    private suspend fun getPokemonList() {
        val pokemonDataList = repositoryGateway.getPokemonList(10)
        _actionFlow.value = PokemonListActionType.LoadSuccess(pokemonDataList))
        Log.d("aaaaaaaaaa", "ActionCreator")
    }

    override operator fun invoke(eventType: PokemonListEventType) {
        GlobalScope.launch {
            getPokemonList()
        }
    }
}