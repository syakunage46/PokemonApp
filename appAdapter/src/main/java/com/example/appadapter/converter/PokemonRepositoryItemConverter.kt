package com.example.appadapter.converter

import com.example.core.pokemon.PokemonData
import com.example.pokemonrepository.data.PokemonRepositoryItem

object PokemonRepositoryItemConverter {
    operator fun invoke(pokemonRepositoryItem: PokemonRepositoryItem): PokemonData {
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