package com.example.appadapter.di

import com.example.appadapter.repository.Repositories
import com.example.appadapter.repository.RepositoryBus
import com.example.core.repository.Repository
import com.example.core.repository.RepositoryRequest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import kotlin.reflect.KClass

@Module
class RepositoryBusModule {

    @Singleton
    @Provides
    fun provideRepositoryBus(): Repository = RepositoryBus(repositories)

    private val repositories: Repositories = emptyMap()
}