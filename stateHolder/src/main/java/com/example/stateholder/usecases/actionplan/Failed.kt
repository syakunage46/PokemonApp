package com.example.stateholder.usecases.actionplan

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.entities.PokemonAction

interface Failed: ActionPlan {
    suspend operator fun invoke(error: Throwable)
}

class FailedInteractor(private val alterCreator: AlterCreatorInterface): Failed {
    override suspend fun invoke(error: Throwable) {
        alterCreator.create(PokemonAction.Failed(error))
    }
}