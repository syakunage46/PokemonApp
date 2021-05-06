package com.example.appadapter.di

import android.app.Application
import com.example.appadapter.repository.PokemonRepositoryAdapter
import com.example.appadapter.repository.Repositories
import com.example.appadapter.repository.RepositoryBus
import com.example.core.repository.Repository
import com.example.core.repository.RepositoryRequest
import com.example.pokemonrepository.PokemonRepositoryGateway
import com.example.pokemonrepository.repository.PokemonRepository
import com.example.redux.pokemon.PokemonRequest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
class RepositoryBusModule {

    @Singleton
    @Provides
    fun provideRepositoryBus(repositories: Repositories): Repository = RepositoryBus(repositories)

    @Singleton
    @Provides
    fun provideRepositories(pokemonRepository: PokemonRepository): Repositories = mapOf(
        PokemonRequest.FetchList::class to PokemonRepositoryAdapter(pokemonRepository)
    )

    @Singleton
    @Provides
    fun providePokemonRepository(app: Application): PokemonRepository
        = PokemonRepositoryGateway.getInstance(app)
}