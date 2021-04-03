package com.example.pokemonrepository.di

import com.example.pokemonrepository.api.PokeApiConnector
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
class PokeApiConnectorModule  {

    @Provides
    fun providePokeApiConnector(): PokeApiConnector {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApiConnector::class.java)
    }

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }
}