package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

@ExperimentalCoroutinesApi
class PokemonListActionCreator(private val repositoryGateway: PokemonExternalRepositoryGateway, private val dispatcher: CoroutineDispatcher = Dispatchers.Default): ActionCreator<PokemonListActionType, PokemonListEventType> {

    @FlowPreview
    override val actionFlow: Flow<PokemonListActionType>
        get() = channel.asFlow()

    private val channel = BroadcastChannel<PokemonListActionType>(Channel.CONFLATED)

    private suspend fun getPokemonList() {
        val pokemonDataList = repositoryGateway.getPokemonList(10)
        channel.send(PokemonListActionType.LoadSuccess(pokemonDataList))
    }

    override operator fun invoke(eventType: PokemonListEventType) {
        CoroutineScope(dispatcher).launch {
            getPokemonList()
        }
    }
}