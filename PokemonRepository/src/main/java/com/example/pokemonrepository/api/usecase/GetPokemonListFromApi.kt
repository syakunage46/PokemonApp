package com.example.pokemonrepository.api.usecase

import android.util.Log
import com.example.pokemonrepository.api.PokeApiConnector
import com.example.pokemonrepository.data.PokemonRepositoryItem
import kotlinx.coroutines.*

interface GetPokemonListFromApi {
    suspend operator fun invoke(limit: Int, offset: Int): List<PokemonRepositoryItem>
}

class GetPokemonListFromApiInteractor (private val apiConnector: PokeApiConnector, val dispatcher: CoroutineDispatcher = Dispatchers.Default): GetPokemonListFromApi {
    override suspend operator fun invoke(limit: Int, offset: Int): List<PokemonRepositoryItem> {
        return withContext(dispatcher) {
            apiConnector.getPokemonListAsync(limit, offset).results.map {
                async { getPokemonProperty(pokeApiIDRegex.find(it.url)?.groupValues?.get(1) ?: it.name) }
            }.map {
                it.await()
            }
        }
    }

    private suspend fun getPokemonProperty(pokemonName: String): PokemonRepositoryItem {
        return withContext(dispatcher) {
            val pokemonResponseAsync = async{ apiConnector.getPokemonAsync(pokemonName) }
            val speciesResponseAsync = async{ apiConnector.getPokemonSpeciesAsync(pokemonName)}
            val pokemonResponse = pokemonResponseAsync.await()
            val speciesResponse = speciesResponseAsync.await()
            return@withContext pokemonResponse.toPokemonRepositoryItem(speciesResponse)
        }
    }

    companion object {
        val pokeApiIDRegex = Regex("""(\d+)/$""")
    }
}