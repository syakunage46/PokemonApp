package com.example.redux.pokemon

import com.example.core.event.Event
import com.example.core.pokemon.PokemonData
import com.example.core.pokemon.PokemonEvent
import com.example.core.repository.Repository
import com.example.core.repository.Response
import com.example.redux.base_component.Action
import com.example.redux.base_component.StoreInterface
import com.example.redux.frameworks.RepositoryManager
import com.example.redux.middleware.ThunkAction

interface PokemonAction: Action {
    class GetList(val payload: List<PokemonData>): PokemonAction
    class AddList(val payload: List<PokemonData>): PokemonAction
    class InLoading: PokemonAction
    class Failed(val payload: Throwable): PokemonAction
    class ShowDetail(val id: Long): PokemonAction

    class FetchList(private val limit: Int, private val offset: Int, private val event: Event): PokemonAction, ThunkAction {
        override fun start() = InLoading()

        override suspend fun invoke(store: StoreInterface, repository: Repository): Action {
            return when(val response = repository.fetch(PokemonRequest.FetchList(limit, offset))) {
                is Response.Success -> {
                    when(event) {
                        is PokemonEvent.OnScrolledToEnd -> AddList(response.data)
                        else -> GetList(response.data)
                    }
                }
                is Response.Failure -> {
                    Failed(response.exception)
                }
            }
        }

    }
}
