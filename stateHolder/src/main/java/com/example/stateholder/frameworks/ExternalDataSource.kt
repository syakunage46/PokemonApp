package com.example.stateholder.frameworks

import android.app.Application
import com.example.pokemonrepository.PokemonRepositoryGateway
import com.example.pokemonrepository.repository.PokemonRepository
import com.example.stateholder.interfaseadapters.ActionRepositoryDataSource

interface ExternalDataSourceInterface: ActionRepositoryDataSource

internal class ExternalDataSource(app: Application): ExternalDataSourceInterface {
    override val pokemonRepository: PokemonRepository = PokemonRepositoryGateway.getInstance(app)
}