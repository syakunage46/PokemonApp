package com.example.myapplication.scene.pokemonlist

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.PokemonData
import com.example.myapplication.di.ApplicationModule
import com.example.myapplication.di.DaggerPokemonRepositoryComponent
import com.example.myapplication.gateway.pokemonrepository.PokemonExternalRepositoryGateway
import com.example.myapplication.presenter.SwipeRefreshDelegate
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListStore(val app: Application): AndroidViewModel(app), SwipeRefreshDelegate {
    @Inject
    lateinit var repositoryGateway: PokemonExternalRepositoryGateway

    init {
        DaggerPokemonRepositoryComponent.builder()
            .applicationModule(ApplicationModule(app))
            .build()
            .inject(this)
    }

    private val _pokemonList = MutableLiveData<List<PokemonData>>()
    val pokemonList: LiveData<List<PokemonData>>
        get() = _pokemonList

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getPokemonList() {
        _isLoading.postValue(true)
        viewModelScope.launch {
            val pokemonDataList = repositoryGateway.getPokemonList(10)
            pokemonDataList.forEach {
                Log.d("pokemon",
                    " \nid    : " + it.id.toString()
                            + "\nname  : " + it.name
                            + "\nheight: " + it.height
                            + "\nweight: " + it.weight
                            + "\nurl   : " + it.frontImageUrl
                )
            }
            _pokemonList.postValue(pokemonDataList)
            _isLoading.postValue(false)
        }
    }

    override fun onSwipeRefresh() {
        getPokemonList()
    }
}