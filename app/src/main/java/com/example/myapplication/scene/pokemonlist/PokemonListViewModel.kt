package com.example.myapplication.scene.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.pokemon.PokemonData
import com.example.myapplication.module.pokemonlist.PokemonListPresenterInterface

class PokemonListViewModel(private val  presenter: PokemonListPresenterInterface): ViewModel() {
    val pokemonList: LiveData<List<PokemonData>> = presenter.pokemonListDataFlow.asLiveData()
    val isLoading: LiveData<Boolean> = presenter.isLoadingFlow.asLiveData()
    val error: LiveData<Throwable?> = presenter.errorFlow.asLiveData()
}