package com.example.stateholder.entities

import com.example.core.pokemon.PokemonData

interface Action

sealed class PokemonAction {
    class GetList(val payload: List<PokemonData>) : Action
}