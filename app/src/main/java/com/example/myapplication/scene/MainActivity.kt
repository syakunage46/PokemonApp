package com.example.myapplication.scene

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.example.core.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.di.ViewModelFactory
import com.example.myapplication.scene.pokemonlist.PokemonListViewModelAbstract
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MainViewModelAbstract by viewModels{ viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.navigation.observe(this, Observer {
            Log.d("aaaaaaaaaa", it.toString())
            if(it is Navigation.PokemonDetail){
                findNavController(R.id.navHostFragment).navigate(R.id.action_pokemonListFragment_to_pokemonDetailFragment)
            }
        })
    }
}