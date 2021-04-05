package com.example.myapplication.scene.pokemonlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.controller.InfiniteScrollListener
import com.example.myapplication.databinding.FragmentPokemonListBinding
import com.example.myapplication.module.pokemonlist.PokemonListController
import com.example.myapplication.module.pokemonlist.PokemonListPresenter.PokemonListAdapter
import com.example.myapplication.module.pokemonlist.store.PokemonListStore
import com.example.myapplication.module.pokemonlist.store.PokemonListStoreFactory
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@FlowPreview
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
        binding.controller = controller
        binding.lifecycleOwner = viewLifecycleOwner

        store.state.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            it.error?.let {
                Toast.makeText(context, "データの取得に失敗しました", Toast.LENGTH_SHORT).show()
            }
        })

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
            val gridLayoutManager = GridLayoutManager(context, 3)
            layoutManager = gridLayoutManager
            scrollListener = InfiniteScrollListener(gridLayoutManager) {
                controller.onScrolledToEnd(store.state.value?.pokemonList?.size ?: 0)
            }
            addOnScrollListener(scrollListener)
        }
    }
}