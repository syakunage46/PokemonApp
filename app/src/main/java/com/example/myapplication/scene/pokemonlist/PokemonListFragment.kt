package com.example.myapplication.scene.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.controller.InfiniteScrollListener
import com.example.myapplication.databinding.FragmentPokemonListBinding
import com.example.myapplication.module.pokemonlist.PokemonListControllerInterface
import com.example.myapplication.module.pokemonlist.presenter.PokemonListAdapter
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.FlowPreview
import javax.inject.Inject

@FlowPreview
class PokemonListFragment: DaggerFragment() {

    lateinit var binding: FragmentPokemonListBinding
    lateinit var pokemonListAdapter: PokemonListAdapter

    @Inject
    lateinit var controller: PokemonListControllerInterface

    @Inject
    lateinit var viewModelFactory: PokemonListViewModelFactory

    val viewModel: PokemonListViewModel by viewModels{ viewModelFactory }
    lateinit var scrollListener: InfiniteScrollListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPokemonListBinding.inflate(inflater)
        binding.controller = controller
        binding.viewModel = viewModel
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
            val gridLayoutManager = GridLayoutManager(context, 3)
            layoutManager = gridLayoutManager
            scrollListener = InfiniteScrollListener(gridLayoutManager) {
                controller.onScrolledToEnd(viewModel.pokemonList.value?.size ?: 0)
            }
            addOnScrollListener(scrollListener)
        }
    }
}