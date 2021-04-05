package com.example.myapplication.module.pokemonlist

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.myapplication.data.PokemonData
import com.example.myapplication.presenter.imageURL

object PokemonListItemPresenter {
    @BindingAdapter("pokemonImage")
    @JvmStatic
    fun ImageView.setPokemonImage(pokemonData: PokemonData) {
        imageURL(pokemonData.frontImageUrl)
    }

    @BindingAdapter("pokemonNumber")
    @JvmStatic
    fun TextView.setPokemonNumber(pokemonData: PokemonData) {
        text = pokemonData.order.toString()
    }

    @BindingAdapter("pokemonName")
    @JvmStatic
    fun TextView.setPokemonName(pokemonData: PokemonData) {
        text = pokemonData.name
    }
}