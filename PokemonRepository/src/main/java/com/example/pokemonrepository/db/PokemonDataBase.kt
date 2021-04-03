package com.example.pokemonrepository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class], version = 1)
abstract class PokemonDataBase: RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "pokemon.db"

        @Volatile
        private var instance: PokemonDataBase? = null

        private fun create(context: Context): PokemonDataBase =
            Room.databaseBuilder(context, PokemonDataBase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): PokemonDataBase =
            (instance ?: create(context)).also { instance = it }
    }

    abstract fun pokemonDao(): PokemonDao
}