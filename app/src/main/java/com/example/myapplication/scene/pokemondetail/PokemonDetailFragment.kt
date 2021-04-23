package com.example.myapplication.scene.pokemondetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPokemonDetailBinding
import dagger.android.support.DaggerFragment

class PokemonDetailFragment: DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentPokemonDetailBinding.inflate(inflater)
        return binding.root
    }
}