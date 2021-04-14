package com.example.stateholder.interfaseadapters

import com.example.core.pokemon.PokemonData
import com.example.stateholder.converter.PokemonRepositoryItemConverter
import com.example.stateholder.usecases.ActionDataProvider

interface ActionRepositoryInterFace: ActionDataProvider

internal class ActionRepository(private val actionRepositoryDataSource: ActionRepositoryDataSource): ActionRepositoryInterFace {
    override suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>
            = actionRepositoryDataSource.pokemonRepository.getPokemonList(limit, offset).map { PokemonRepositoryItemConverter(it) }
}