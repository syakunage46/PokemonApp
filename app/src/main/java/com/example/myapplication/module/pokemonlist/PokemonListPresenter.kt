package com.example.myapplication.module.pokemonlist

import com.example.core.pokemon.PokemonData
import com.example.core.pokemon.PokemonStateElement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface PokemonListPresenterInterface {
    val pokemonListDataFlow: Flow<List<PokemonData>>
    val isLoadingFlow: Flow<Boolean>
    val errorFlow: Flow<Throwable?>
}

class PokemonListPresenter(private val pokemonStateFlow: Flow<PokemonStateElement>) : PokemonListPresenterInterface {
    override val pokemonListDataFlow: Flow<List<PokemonData>> = pokemonStateFlow.map{ it.pokemonDataList }
    override val isLoadingFlow: Flow<Boolean> = pokemonStateFlow.map{ it.isLoading }
    override val errorFlow: Flow<Throwable?> = pokemonStateFlow.map{ it.error }
}