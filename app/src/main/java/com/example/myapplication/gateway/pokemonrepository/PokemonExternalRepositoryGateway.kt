package com.example.myapplication.gateway.pokemonrepository

import javax.inject.Inject

class PokemonExternalRepositoryGateway @Inject constructor(private val useCaseBus: PokemonExternalRepositoryUseCases): PokemonExternalRepositoryUseCases by useCaseBus