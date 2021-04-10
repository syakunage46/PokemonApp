package com.example.stateholder.usecases

import com.example.stateholder.entities.AlterCreatorInterFace
import com.example.stateholder.usecases.actionplan.GetPokemonList
import com.example.stateholder.usecases.actionplan.GetPokemonListInteractor

interface ActionPlannerInterFace

interface PokemonListActionPlannerInterFace: ActionPlannerInterFace {
    val getPokemonList: GetPokemonList
}

internal class PokemonListActionPlanner(alterCreatorInterFace: AlterCreatorInterFace): PokemonListActionPlannerInterFace {
    override val getPokemonList: GetPokemonList = GetPokemonListInteractor(alterCreatorInterFace)
}