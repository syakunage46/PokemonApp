package com.example.pokemonrepository.api.usecase

import com.example.pokemonrepository.api.PokeApiConnector
import com.example.pokemonrepository.data.PokemonRepositoryItem

interface GetPokemonListFromApi {
    suspend operator fun invoke(limit: Int): List<PokemonRepositoryItem>
}

class GetPokemonListFromApiInteractor (private val apiConnector: PokeApiConnector): GetPokemonListFromApi {
    override suspend operator fun invoke(limit: Int): List<PokemonRepositoryItem> {
        return apiConnector.getPokemonListAsync(limit).await().results.map {
            val pokemonResponse = apiConnector.getPokemonAsync(it.name).await()
            val speciesResponse = apiConnector.getPokemonSpeciesAsync(pokemonResponse.id).await()
            val nameJp = speciesResponse.nameJp
            pokemonResponse.toPokeMonProperty(nameJp)
        }
    }
}