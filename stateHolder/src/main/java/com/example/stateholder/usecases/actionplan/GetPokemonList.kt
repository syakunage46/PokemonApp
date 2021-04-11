package com.example.stateholder.usecases.actionplan

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.entities.PokemonAction
import com.example.stateholder.usecases.ActionDataProvider

interface GetPokemonList: ActionPlan {
    suspend operator fun invoke(limit: Int, offset: Int)
}

class GetPokemonListInteractor(override val alterCreator: AlterCreatorInterface, private val actionDataProvider: ActionDataProvider) : GetPokemonList {
    override suspend operator fun invoke(limit: Int, offset: Int){
        alterCreator.create(PokemonAction.GetList(actionDataProvider.getPokemonList(limit, offset)))
    }
}