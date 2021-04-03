package com.example.pokemonrepository.repository.local

import com.example.pokemonrepository.data.PokemonRepositoryItem
import com.example.pokemonrepository.db.PokemonDao
import com.example.pokemonrepository.db.PokemonEntity

class PokemonLocalDataSourceService(private val pokemonDao: PokemonDao): PokemonLocalDataSource {
    override suspend fun addPokemon(pokemon: PokemonRepositoryItem) = pokemonDao.addPokemon(PokemonEntity.from(pokemon))
    override suspend fun getPokemonList(limit: Int): List<PokemonRepositoryItem> = pokemonDao.getPokemonEntities(limit).map { it.toPokemonProperty() }
}