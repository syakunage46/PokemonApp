package com.example.pokemonrepository.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.pokemonrepository.data.PokemonRepositoryItem

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Long,
    val order: Long,
    @ColumnInfo(name = "name_eng")
    val nameEng: String,
    @ColumnInfo(name = "name_jp")
    val nameJp: String?,
    val weight: Long,
    val height: Long,
    val genera: String,
    @ColumnInfo(name = "flavor_text")
    val flavorText: String,
    @ColumnInfo(name = "front_image_url")
    val frontImageUrl: String,
) {
    fun toPokemonProperty() = PokemonRepositoryItem(
        id = id,
        order = order,
        nameEng = nameEng,
        nameJp = nameJp,
        weight = weight,
        height = height,
        genera = genera,
        flavorText = flavorText,
        frontImageUrl = frontImageUrl
    )

    companion object {
        fun from(pokemonRepositoryItem: PokemonRepositoryItem) = PokemonEntity(
            id = pokemonRepositoryItem.id,
            order = pokemonRepositoryItem.order,
            nameEng = pokemonRepositoryItem.nameEng,
            nameJp = pokemonRepositoryItem.nameJp,
            weight = pokemonRepositoryItem.weight,
            height = pokemonRepositoryItem.height,
            genera = pokemonRepositoryItem.genera,
            flavorText = pokemonRepositoryItem.flavorText,
            frontImageUrl = pokemonRepositoryItem.frontImageUrl
        )
    }
}