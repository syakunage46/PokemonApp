package com.example.stateholder.di

import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.usecases.ActionDataProvider
import com.example.stateholder.usecases.PokemonListActionPlanner
import com.example.stateholder.usecases.PokemonListActionPlannerInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActionPlannerModule {

    @Singleton
    @Provides
    fun providePokemonListActionPlanner(alterCreatorInterFace: AlterCreatorInterface, actionDataProvider: ActionDataProvider): PokemonListActionPlannerInterface
            = PokemonListActionPlanner(alterCreatorInterFace, actionDataProvider)
}