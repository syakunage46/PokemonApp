package com.example.myapplication.module.pokemonlist.store

import com.example.myapplication.data.PokemonData
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.flux.Dispatcher
import com.example.myapplication.flux.State
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@FlowPreview
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
class PokemonListDispatcher(override val actionCreator: ActionCreator<PokemonListActionType, *>, private val dispatcher: CoroutineDispatcher = Dispatchers.Default) : Dispatcher<PokemonListActionType, List<PokemonData>> {

    override val state: Flow<State<List<PokemonData>>>
        get() = channel.asFlow()
    private val channel = BroadcastChannel<State<List<PokemonData>>>(Channel.BUFFERED)

    init {
        actionCreator.actionFlow.onEach {
            when(it) {
                is PokemonListActionType.LoadSuccess -> {
                    channel.send(State(it.pokemonDataList))
                }
                is PokemonListActionType.Error -> {

                }
            }
        }.launchIn(CoroutineScope(dispatcher))
    }
}