package com.example.myapplication.module.pokemonlist

import com.example.core.pokemon.PokemonData
import com.example.core.pokemon.PokemonStateElement
import com.example.myapplication.interface_adapters.gateway.ElementStreet
import kotlinx.coroutines.flow.Flow

interface PokemonListPresenterInterface {
    val pokemonListDataFlow: Flow<List<PokemonData>>
    val isLoadingFlow: Flow<Boolean>
    val errorFlow: Flow<Throwable?>
}

class PokemonListPresenter(pokemonStreet: ElementStreet<PokemonStateElement>) : PokemonListPresenterInterface {
    override val pokemonListDataFlow: Flow<List<PokemonData>> = pokemonStreet{ pokemonDataList }
    override val isLoadingFlow: Flow<Boolean> = pokemonStreet{ isLoading }
    override val errorFlow: Flow<Throwable?> = pokemonStreet{ error }
}