package com.example.myapplication.scene.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.controller.InfiniteScrollListener
import com.example.myapplication.databinding.FragmentPokemonListBinding
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListPresenter.PokemonListAdapter
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@FlowPreview
class PokemonListFragment: DaggerFragment() {

    lateinit var binding: FragmentPokemonListBinding
    lateinit var pokemonListAdapter: PokemonListAdapter

    @Inject
    lateinit var controller: PokemonListController

    lateinit var scrollListener: InfiniteScrollListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPokemonListBinding.inflate(inflater)
        binding.controller = controller
        binding.lifecycleOwner = viewLifecycleOwner

        bindRecyclerView()
        controller.onCreate()
        return binding.root
    }

    private fun bindRecyclerView() {
        if (!::pokemonListAdapter.isInitialized){
            pokemonListAdapter = PokemonListAdapter()
        }

//        binding.pokemonListFrame.pokemonList.apply {
//            adapter = pokemonListAdapter
//            val gridLayoutManager = GridLayoutManager(context, 3)
//            layoutManager = gridLayoutManager
//            scrollListener = InfiniteScrollListener(gridLayoutManager) {
//                controller.onScrolledToEnd(store.state.value?.pokemonList?.size ?: 0)
//            }
//            addOnScrollListener(scrollListener)
//        }
    }
}