package com.example.pokemonrepository.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokemonrepository.data.PokemonProperty

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name_eng")
    val nameEng: String,
    @ColumnInfo(name = "name_jp")
    val nameJp: String?,
    val weight: Long,
    val height: Long
) {
    fun toPokemonProperty() = PokemonProperty(
        id = id,
        nameEng = nameEng,
        nameJp = nameJp,
        weight = weight,
        height = height
    )

    companion object {
        fun from(pokemonProperty: PokemonProperty) = PokemonEntity(
            id = pokemonProperty.id,
            nameEng = pokemonProperty.nameEng,
            nameJp = pokemonProperty.nameJp,
            weight = pokemonProperty.weight,
            height = pokemonProperty.height
        )
    }
}