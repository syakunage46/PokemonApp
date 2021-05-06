package com.example.redux.pokemon

import com.example.core.pokemon.PokemonData
import com.example.core.repository.RepositoryRequest

interface PokemonRequest {
    class FetchList(val limit: Int,  val offset: Int): RepositoryRequest<List<PokemonData>>(), PokemonRequest
}