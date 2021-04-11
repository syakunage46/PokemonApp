package com.example.stateholder.usecases

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.usecases.actionplan.GetPokemonList
import com.example.stateholder.usecases.actionplan.GetPokemonListInteractor

interface ActionPlannerInterface

interface PokemonListActionPlannerInterface: ActionPlannerInterface {
    val getPokemonList: GetPokemonList
}

internal class PokemonListActionPlanner(alterCreatorInterFace: AlterCreatorInterface, actionDataProvider: ActionDataProvider): PokemonListActionPlannerInterface {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(alterCreatorInterFace, actionDataProvider)
}