package com.example.myapplication.data

data class PokemonData(
    val id: Long,
    val order: Long,
    val name: String,
    val weight: Long,
    val height: Long,
    val genera: String,
    val flavorText: String,
    val frontImageUrl: String
)