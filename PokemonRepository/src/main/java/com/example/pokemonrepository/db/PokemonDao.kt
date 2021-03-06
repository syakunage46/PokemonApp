package com.example.pokemonrepository.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPokemon(pokemonEntity: PokemonEntity)

    @Query("SELECT * FROM pokemon LIMIT :limit")
    suspend fun getPokemonEntities(limit: Int): List<PokemonEntity>
}