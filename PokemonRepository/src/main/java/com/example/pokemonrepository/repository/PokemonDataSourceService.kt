package com.example.pokemonrepository.repository

import com.example.pokemonrepository.api.PokemonApi
import com.example.pokemonrepository.data.PokemonProperty
import com.example.pokemonrepository.db.PokemonDao
import com.example.pokemonrepository.db.PokemonEntity

class PokemonDataSourceService(private val pokemonDao: PokemonDao, private val pokemonApi: PokemonApi): PokemonDataSource {
    override suspend fun getPokemonList(limit: Int): List<PokemonProperty> {
        var pokemonList: MutableList<PokemonProperty> = pokemonDao.getPokemonEntities(limit).map { it.toPokemonProperty() }.toMutableList()
        return if (pokemonList.size >= limit) {
            pokemonList
        } else {
            pokemonList = pokemonApi.getPokemonList(limit).toMutableList()
            pokemonList.forEach { pokemonDao.addPokemon(PokemonEntity.from(it)) }
            pokemonList
        }
    }
}