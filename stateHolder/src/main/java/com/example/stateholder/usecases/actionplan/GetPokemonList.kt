package com.example.stateholder.usecases.actionplan

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.entities.PokemonAction

interface GetPokemonList: ActionPlan {
    override suspend operator fun invoke()
}

class GetPokemonListInteractor(override val alterCreator: AlterCreatorInterface) : GetPokemonList {
    override suspend operator fun invoke(){
        alterCreator.create(PokemonAction.GetList(emptyList()))
    }
}