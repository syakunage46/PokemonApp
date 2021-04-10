package com.example.stateholder.di

import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.AlterCreator
import com.example.stateholder.entities.AlterCreatorInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AlterCreatorModule {

    @Singleton
    @Provides
    fun provideAlterCreator(): AlterCreatorInterface = AlterCreator()

    @Singleton
    @Provides
    fun provideAlterFlow(alterCreatorInterFace: AlterCreatorInterface): NonWildcardFlow<Alter>
            = alterCreatorInterFace.alterFlow
}