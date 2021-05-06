package com.example.redux.di

import com.example.core.repository.Repository
import com.example.redux.ReduxGateway
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ReduxStateModule::class,
    ReduxReducerModule::class,
    RepositoryModule::class
])
interface ReduxComponent {
    fun inject(reduxGateway: ReduxGateway)

    @Component.Factory
    interface Factory {
        fun create(repositoryModule: RepositoryModule): ReduxComponent
    }
}

@Module
class RepositoryModule(private val repository: Repository) {
    @Provides
    fun provideRepository(): Repository = repository
}