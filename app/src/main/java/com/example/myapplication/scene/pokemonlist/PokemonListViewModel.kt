package com.example.myapplication.scene.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.pokemon.PokemonData
import com.example.myapplication.module.pokemonlist.PokemonListPresenterInterface
import javax.inject.Inject

abstract class PokemonListViewModelAbstract: ViewModel() {
    abstract val pokemonList: LiveData<List<PokemonData>>
    abstract val isLoading: LiveData<Boolean>
    abstract val error: LiveData<Throwable?>
}

class PokemonListViewModel @Inject constructor(presenter: PokemonListPresenterInterface): PokemonListViewModelAbstract() {
    override val pokemonList: LiveData<List<PokemonData>> = presenter.pokemonListDataFlow.asLiveData()
    override val isLoading: LiveData<Boolean> = presenter.isLoadingFlow.asLiveData()
    override val error: LiveData<Throwable?> = presenter.errorFlow.asLiveData()
}