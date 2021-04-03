package com.example.pokemonrepository.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokemonrepository.data.PokemonRepositoryItem

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "name_eng")
    val nameEng: String,
    @ColumnInfo(name = "name_jp")
    val nameJp: String?,
    val weight: Long,
    val height: Long,
    @ColumnInfo(name = "front_image_url")
    val frontImageUrl: String,
) {
    fun toPokemonProperty() = PokemonRepositoryItem(
        id = id,
        nameEng = nameEng,
        nameJp = nameJp,
        weight = weight,
        height = height,
        frontImageUrl = frontImageUrl
    )

    companion object {
        fun from(pokemonRepositoryItem: PokemonRepositoryItem) = PokemonEntity(
            id = pokemonRepositoryItem.id,
            nameEng = pokemonRepositoryItem.nameEng,
            nameJp = pokemonRepositoryItem.nameJp,
            weight = pokemonRepositoryItem.weight,
            height = pokemonRepositoryItem.height,
            frontImageUrl = pokemonRepositoryItem.frontImageUrl
        )
    }
}