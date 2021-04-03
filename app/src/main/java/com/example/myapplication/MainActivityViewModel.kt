package com.example.myapplication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.di.ApplicationModule
import com.example.myapplication.di.DaggerPokemonRepositoryComponent
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel(val app: Application): AndroidViewModel(app) {
    @Inject
    lateinit var repositoryUseCases: PokemonExternalRepositoryGateway

    init {
        DaggerPokemonRepositoryComponent.builder()
            .applicationModule(ApplicationModule(app))
            .build()
            .inject(this)
    }

    fun getPokemonList() {
        viewModelScope.launch {
            repositoryUseCases.getPokemonList(10).forEach {
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