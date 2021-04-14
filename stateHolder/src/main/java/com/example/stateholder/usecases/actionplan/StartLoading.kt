package com.example.stateholder.usecases.actionplan

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.entities.PokemonAction

interface StartLoading: ActionPlan {
    suspend operator fun invoke()
}

class StartLoadingInteractor(private val alterCreator: AlterCreatorInterface): StartLoading {
    override suspend fun invoke() {
        alterCreator.create(PokemonAction.StartLoading())
    }
}