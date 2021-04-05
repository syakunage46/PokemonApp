package com.example.pokemonrepository

import android.app.Application
import com.example.pokemonrepository.di.DaggerPokemonRepositoryGatewayComponent
import com.example.pokemonrepository.repository.PokemonRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonRepositoryGateway {
    companion object {
        @Volatile
        private var instance: PokemonRepository? = null

        private fun create(app: Application): PokemonRepository {
            return DaggerPokemonRepositoryGatewayComponent.factory().create(app).pokemonRepository()
        }

        fun getInstance(app: Application): PokemonRepository =
            (instance ?: create(app)).also { instance = it }
    }
}