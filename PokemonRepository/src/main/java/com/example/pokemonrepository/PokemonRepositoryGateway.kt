package com.example.pokemonrepository

import android.app.Application
import com.example.pokemonrepository.di.DaggerPokemonRepositoryGatewayComponent
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonRepositoryGateway @Inject constructor(private val useCaseBus: PokemonRepositoryUseCaseBus): PokemonRepositoryUseCases by useCaseBus {

    companion object {
        @Volatile
        private var instance: PokemonRepositoryGateway? = null

        private fun create(app: Application): PokemonRepositoryGateway {
            return DaggerPokemonRepositoryGatewayComponent.factory().create(app).pokemonRepositoryGateway()
        }

        fun getInstance(app: Application): PokemonRepositoryGateway =
            (instance ?: create(app)).also { instance = it }
    }
}