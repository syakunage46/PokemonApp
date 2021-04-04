package com.example.myapplication.scene.pokemonlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.controller.InfiniteScrollListener
import com.example.myapplication.databinding.FragmentPokemonListBinding
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListPresenter.PokemonListAdapter
import com.example.myapplication.module.pokemonlist.store.PokemonListStore
import com.example.myapplication.module.pokemonlist.store.PokemonListStoreFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class PokemonListFragment: DaggerFragment() {

    lateinit var binding: FragmentPokemonListBinding
    lateinit var pokemonListAdapter: PokemonListAdapter
    @Inject
    lateinit var factory: PokemonListStoreFactory
    @Inject
    lateinit var controller: PokemonListController

    val store: PokemonListStore by viewModels { factory }

    lateinit var scrollListener: InfiniteScrollListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPokemonListBinding.inflate(inflater)
        binding.store = store
        binding.lifecycleOwner = viewLifecycleOwner
        bindRecyclerView()
        controller.onCreate()
        return binding.root
    }

    private fun bindRecyclerView() {
        if (!::pokemonListAdapter.isInitialized){
            pokemonListAdapter = PokemonListAdapter()
        }

        binding.pokemonListFrame.pokemonList.apply {
            adapter = pokemonListAdapter
            val linearLayoutManager = LinearLayoutManager(context)
            layoutManager = linearLayoutManager
            scrollListener = InfiniteScrollListener(linearLayoutManager) {
                controller.onScrolledToEnd(store.state.value?.pokemonList?.size ?: 0)
            }
            addOnScrollListener(scrollListener)
        }

        binding.pokemonListFrame.pokemonListRefresh.setOnRefreshListener {
            controller.onCreate()
            scrollListener.refresh()
        }
    }
}