package com.example.myapplication.presenter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.myapplication.data.PokemonData

object PokemonListItemPresenter {
    @BindingAdapter("pokemonImage")
    @JvmStatic
    fun ImageView.setPokemonImage(pokemonData: PokemonData) {
        Glide.with(this)
            .load(pokemonData.frontImageUrl)
            .into(this)
    }

    @BindingAdapter("pokemonName")
    @JvmStatic
    fun TextView.setPokemonName(pokemonData: PokemonData) {
        text = pokemonData.name
    }
}