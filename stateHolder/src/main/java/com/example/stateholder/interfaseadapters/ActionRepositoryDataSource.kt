package com.example.stateholder.interfaseadapters

import com.example.pokemonrepository.repository.PokemonRepository

interface ActionRepositoryDataSource {
    val pokemonRepository: PokemonRepository
}