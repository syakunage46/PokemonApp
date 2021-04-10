package com.example.stateholder.usecases.actionplan

import com.example.stateholder.data.PokemonData
import com.example.stateholder.entities.Action
import com.example.stateholder.entities.AlterCreatorInterFace
import com.example.stateholder.entities.PokemonAction

interface GetPokemonList: ActionPlan {
    override suspend operator fun invoke()
}

class GetPokemonListInteractor(override val alterCreator: AlterCreatorInterFace) : GetPokemonList {
    override suspend operator fun invoke(){
        alterCreator.create(PokemonAction.GetList(emptyList()))
    }
}