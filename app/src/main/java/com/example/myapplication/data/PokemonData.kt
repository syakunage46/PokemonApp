package com.example.myapplication.data

import com.example.pokemonrepository.data.PokemonRepositoryItem

data class PokemonData(
    val id: Long,
    val order: Long,
    val name: String,
    val weight: Long,
    val height: Long,
    val genera: String,
    val flavorText: String,
    val frontImageUrl: String
) {
    companion object {
        fun from(pokemonRepositoryItem: PokemonRepositoryItem): PokemonData {
            return PokemonData(
                id = pokemonRepositoryItem.id,
                order = pokemonRepositoryItem.order,
                name = pokemonRepositoryItem.name,
                weight = pokemonRepositoryItem.weight,
                height = pokemonRepositoryItem.height,
                genera = pokemonRepositoryItem.genera,
                flavorText = pokemonRepositoryItem.flavorText,
                frontImageUrl = pokemonRepositoryItem.frontImageUrl
            )
        }
    }
}