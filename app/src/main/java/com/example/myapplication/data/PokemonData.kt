package com.example.myapplication.data

import com.example.pokemonrepository.data.PokemonRepositoryItem

data class PokemonData(
    val id: Long,
    val name: String,
    val weight: Long,
    val height: Long,
    val frontImageUrl: String
) {
    companion object {
        fun from(pokemonRepositoryItem: PokemonRepositoryItem): PokemonData {
            return PokemonData(
                id = pokemonRepositoryItem.id,
                name = pokemonRepositoryItem.name,
                weight = pokemonRepositoryItem.weight,
                height = pokemonRepositoryItem.height,
                frontImageUrl = pokemonRepositoryItem.frontImageUrl
            )
        }
    }
}