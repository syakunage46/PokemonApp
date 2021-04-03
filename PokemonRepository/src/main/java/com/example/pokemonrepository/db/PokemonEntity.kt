package com.example.pokemonrepository.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokemonrepository.data.PokemonProperty

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val weight: Long,
    val height: Long
) {
    fun toPokemonProperty() = PokemonProperty(
        id = id,
        name = name,
        weight = weight,
        height = height
    )

    companion object {
        fun from(pokemonProperty: PokemonProperty) = PokemonEntity(
            id = pokemonProperty.id,
            name = pokemonProperty.name,
            weight = pokemonProperty.weight,
            height = pokemonProperty.height
        )
    }
}