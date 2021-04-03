package com.example.pokemonrepository.api.usecase

import com.example.pokemonrepository.api.PokeApiConnector
import com.example.pokemonrepository.data.PokemonProperty
import com.example.pokemonrepository.repository.PokemonRepository
import com.example.pokemonrepository.usecase.GetPokemonList

interface GetPokemonListFromApi {
    suspend operator fun invoke(limit: Int): List<PokemonProperty>
}

class GetPokemonListFromApiInteractor (private val apiConnector: PokeApiConnector): GetPokemonListFromApi {
    override suspend operator fun invoke(limit: Int): List<PokemonProperty> {
        return apiConnector.getPokemonListAsync(limit).await().results.map {
            val pokemonResponse = apiConnector.getPokemonAsync(it.name).await()
            val speciesResponse = apiConnector.getPokemonSpeciesAsync(pokemonResponse.id).await()
            val nameJp = speciesResponse.nameJp
            pokemonResponse.toPokeMonProperty(nameJp)
        }
    }
}