package com.example.pokemonrepository.repository.local

import com.example.pokemonrepository.data.PokemonProperty

interface PokemonLocalDataSource {
    suspend fun addPokemon(pokemon: PokemonProperty)
    suspend fun getPokemonList(limit: Int): List<PokemonProperty>
}