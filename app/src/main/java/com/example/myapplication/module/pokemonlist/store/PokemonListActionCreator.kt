package com.example.myapplication.module.pokemonlist.store

import android.util.Log
import com.example.myapplication.flux.ActionCreator
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.*

@ExperimentalCoroutinesApi
class PokemonListActionCreator(private val repositoryGateway: PokemonExternalRepositoryGateway,
                               private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default)
    : ActionCreator<PokemonListActionType, PokemonListEventType>{

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _actionFlow.offer(PokemonListActionType.Error(throwable))
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    private val _actionFlow = ConflatedBroadcastChannel<PokemonListActionType>()
    override val actionFlow: Flow<PokemonListActionType> = _actionFlow.asFlow()

    private fun launchDataLoad(block: suspend () -> PokemonListActionType) {
        scope.launch {
            _actionFlow.send(PokemonListActionType.InLoading())
            val action = block()
            _actionFlow.send(action)
        }
    }

    private suspend fun getPokemonList(offset: Int = 0)
        = PokemonListActionType.LoadSuccess(repositoryGateway.getPokemonList(REQUEST_ITEM_COUNT, offset))

    private suspend fun appendPokemonList(offset: Int)
        = PokemonListActionType.AdditionalLoadSuccess(repositoryGateway.getPokemonList(REQUEST_ITEM_COUNT, offset))


    override operator fun invoke(eventType: PokemonListEventType) {
        launchDataLoad {
            return@launchDataLoad when(eventType){
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