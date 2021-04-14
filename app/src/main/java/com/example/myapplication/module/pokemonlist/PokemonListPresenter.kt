package com.example.myapplication.module.pokemonlist

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.core.pokemon.PokemonData
import com.example.core.pokemon.PokemonStateElement
import com.example.core.state.State
import com.example.myapplication.frameworks.StateListener
import com.example.myapplication.frameworks.StateListenerInterface
import com.example.myapplication.module.pokemonlist.presenter.PokemonListAdapter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

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

@BindingAdapter("bindPokemonList")
fun RecyclerView.bindItems(items: List<PokemonData>?) {
    items?.let {
        val adapter = adapter as PokemonListAdapter
        adapter.submitList(it)
    }
}