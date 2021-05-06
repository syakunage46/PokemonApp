package com.example.appadapter.repository

import com.example.appadapter.converter.PokemonRepositoryItemConverter
import com.example.core.repository.Repository
import com.example.core.repository.RepositoryRequest
import com.example.pokemonrepository.repository.PokemonRepository
import com.example.redux.pokemon.PokemonRequest

class PokemonRepositoryAdapter(private val pokemonRepository: PokemonRepository): Repository() {
    override suspend fun <T, R : RepositoryRequest<T>> handle(request: R) {
        when(request){
            is PokemonRequest.FetchList -> {
                val pokemonList = pokemonRepository.getPokemonList(request.limit,request.offset).map{ PokemonRepositoryItemConverter(it) }
                request.success(pokemonList)
            }
        }
    }

}