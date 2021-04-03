package com.example.pokemonrepository.di

import android.app.Application
import com.example.pokemonrepository.db.PokemonDataBase
import dagger.Module
import dagger.Provides

@Module
class PokemonDaoModule  {
    @Provides
    fun providePokemonDao(app: Application) = PokemonDataBase.getInstance(app).pokemonDao()
}