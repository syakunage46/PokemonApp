package com.example.myapplication.scene.pokemonlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.R
import com.example.myapplication.interface_adapters.controller.InfiniteScrollListener
import com.example.myapplication.databinding.FragmentPokemonListBinding
import com.example.myapplication.di.ViewModelFactory
import com.example.myapplication.module.pokemonlist.PokemonListControllerInterface
import com.example.myapplication.module.pokemonlist.presenter.PokemonListAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PokemonListFragment: DaggerFragment() {

    lateinit var binding: FragmentPokemonListBinding

    @Inject
    lateinit var controller: PokemonListControllerInterface

    @Inject
    lateinit var pokemonListAdapter: PokemonListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: PokemonListViewModelAbstract by viewModels{ viewModelFactory }
    lateinit var scrollListener: InfiniteScrollListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPokemonListBinding.inflate(inflater)
        binding.controller = controller
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.error.observe(viewLifecycleOwner, Observer {
            it ?: return@Observer
            Toast.makeText(context, R.string.fail_get_pokemon_list, Toast.LENGTH_SHORT).show()
        })

        bindRecyclerView()
        controller.onCreate()
        return binding.root
    }

    private fun bindRecyclerView() {
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