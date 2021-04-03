package com.example.myapplication.scene.pokemonlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentPokemonListBinding
import com.example.myapplication.presenter.PokemonListPresenter.PokemonListAdapter


class PokemonListFragment : Fragment() {

    lateinit var binding: FragmentPokemonListBinding
    lateinit var pokemonListAdapter: PokemonListAdapter
    private val store: PokemonListStore by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        store.getPokemonList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentPokemonListBinding.inflate(inflater)
        binding.store = store
        binding.lifecycleOwner = viewLifecycleOwner
        bindRecyclerView()

        return binding.root
    }

    private fun bindRecyclerView() {
        if (!::pokemonListAdapter.isInitialized){
            pokemonListAdapter = PokemonListAdapter()
        }

        binding.pokemonListFrame.pokemonList.apply {
            adapter = pokemonListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}