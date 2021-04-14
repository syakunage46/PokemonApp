package com.example.stateholder.di

import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.AlterCreator
import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.entities.AlterStateReceiver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AlterCreatorModule {

    @Singleton
    @Provides
    fun provideAlterCreator(alterStateReceiver: AlterStateReceiver): AlterCreatorInterface
            = AlterCreator(alterStateReceiver)
}