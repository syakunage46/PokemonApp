package com.example.stateholder.usecases.actionplan

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.entities.PokemonAction
import com.example.stateholder.usecases.ActionDataProvider

interface AddPokemonList: ActionPlan {
    suspend operator fun invoke(limit: Int, offset: Int)
}

class AddPokemonListInteractor(private val alterCreator: AlterCreatorInterface,
                                         private val actionDataProvider: ActionDataProvider): AddPokemonList {
    override suspend fun invoke(limit: Int, offset: Int) {
        alterCreator.create(PokemonAction.AddList(actionDataProvider.getPokemonList(limit, offset)))
    }

}