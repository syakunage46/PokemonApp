package com.example.pokemonrepository.repository.local

import com.example.pokemonrepository.data.PokemonProperty
import com.example.pokemonrepository.db.PokemonDao
import com.example.pokemonrepository.db.PokemonEntity

class PokemonLocalDataSourceService(private val pokemonDao: PokemonDao): PokemonLocalDataSource {
    override suspend fun addPokemon(pokemon: PokemonProperty) = pokemonDao.addPokemon(PokemonEntity.from(pokemon))
    override suspend fun getPokemonList(limit: Int): List<PokemonProperty> = pokemonDao.getPokemonEntities(limit).map { it.toPokemonProperty() }
}