package com.example.pokemonrepository.api

import com.example.pokemonrepository.data.PokemonProperty

class PokemonApiService(private val apiConnector: PokeApiConnector): PokemonApi {
    override suspend fun getPokemonList(limit: Int): List<PokemonProperty> {
        return apiConnector.getPokemonListAsync(limit).await().results.map {
            var pokemon = apiConnector.getPokemonAsync(it.name).await().toPokeMonProperty()
            val species = apiConnector.getPokemonSpeciesAsync(pokemon.id).await()
            species.names.find { it.language.name == "ja" }?.let {
                pokemon.name = it.name
            }
            pokemon
        }
    }
}