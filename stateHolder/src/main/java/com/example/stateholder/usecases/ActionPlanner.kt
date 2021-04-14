package com.example.stateholder.usecases

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.usecases.actionplan.*

interface ActionPlannerInterface

interface PokemonListActionPlannerInterface: ActionPlannerInterface {
    val getPokemonList: GetPokemonList
    val addPokemonList: AddPokemonList
    val startLoading: StartLoading
    val filed: Failed
}

internal class PokemonListActionPlanner(alterCreatorInterFace: AlterCreatorInterface, actionDataProvider: ActionDataProvider): PokemonListActionPlannerInterface {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(alterCreatorInterFace, actionDataProvider)
    override val addPokemonList: AddPokemonList = AddPokemonListInteractor(alterCreatorInterFace, actionDataProvider)
    override val startLoading: StartLoading = StartLoadingInteractor(alterCreatorInterFace)
    override val filed: Failed = FailedInteractor(alterCreatorInterFace)
}