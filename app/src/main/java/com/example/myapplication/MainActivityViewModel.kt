package com.example.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonrepository.PokemonRepositoryGateway
import kotlinx.coroutines.launch

class MainActivityViewModel(val app: Application): AndroidViewModel(app) {
    fun getPokemonList() {
        val useCases = PokemonRepositoryGateway.getInstance(app)
        viewModelScope.launch {
            useCases.getPokemonList(10).forEach {
                Log.d("pokemon",
                    " \nid    : " + it.id.toString()
                            + "\nname  : " + it.name
                            + "\nheight: " + it.height
                            + "\nweight: " + it.weight
                )
            }
        }
    }
}