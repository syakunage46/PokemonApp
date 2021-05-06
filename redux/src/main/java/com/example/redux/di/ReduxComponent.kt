package com.example.redux.di

import com.example.core.repository.Repository
import com.example.redux.ReduxGateway
import com.example.redux.base_component.EventConverterInterface
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActionModule::class,
    EventConverterModule::class,
    ReduxMiddlewareModule::class,
    ReduxStateModule::class,
    ReduxReducerModule::class,
    RepositoryModule::class
])
interface ReduxComponent {
    fun inject(reduxGateway: ReduxGateway)

    @Component.Factory
    interface Factory {
        fun create(repositoryModule: RepositoryModule, eventConverterModule: EventConverterModule): ReduxComponent
    }
}

@Module
class RepositoryModule(private val repository: Repository) {
    @Provides
    fun provideRepository(): Repository = repository
}

@Module
class EventConverterModule(private val eventConverter: EventConverterInterface) {
    @Provides
    fun provideEventConverter(): EventConverterInterface = eventConverter
}