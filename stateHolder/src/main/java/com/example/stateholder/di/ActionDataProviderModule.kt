package com.example.stateholder.di

import android.app.Application
import com.example.stateholder.frameworks.ExternalDataSource
import com.example.stateholder.frameworks.ExternalDataSourceInterface
import com.example.stateholder.interfaseadapters.ActionRepository
import com.example.stateholder.interfaseadapters.ActionRepositoryInterFace
import com.example.stateholder.usecases.ActionDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActionDataProviderModule {

    @Singleton
    @Provides
    fun provideExternalDataSource(app: Application): ExternalDataSourceInterface = ExternalDataSource(app)

    @Singleton
    @Provides
    fun provideActionRepository(externalDataSource: ExternalDataSourceInterface): ActionRepositoryInterFace = ActionRepository(externalDataSource)

    @Singleton
    @Provides
    fun provideActionDataProvider(actionRepository: ActionRepositoryInterFace): ActionDataProvider = actionRepository
}