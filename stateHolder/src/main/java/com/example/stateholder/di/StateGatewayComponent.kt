package com.example.stateholder.di

import android.app.Application
import com.example.stateholder.StateGateway
import com.example.stateholder.StateGatewayInterface
import com.example.stateholder.entities.AlterCreatorInterface
import com.example.stateholder.frameworks.EventListenerInterface
import com.example.stateholder.frameworks.StateCasterInterface
import com.example.stateholder.interfaseadapters.Event
import com.example.stateholder.usecases.PokemonListActionPlanner
import com.example.stateholder.usecases.PokemonListActionPlannerInterface
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ActionDataProviderModule::class,
        ActionPlannerModule::class,
        AlterCreatorModule::class,
        EventControllerModule::class,
        EventListenerModule::class,
        StateCasterModule::class,
        StateDispatcherModule::class,
        StateGatewayModule::class,
        StateStoreModule::class]
)
interface StateGatewayComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application, @BindsInstance eventFlow: NonWildcardFlow<Event>): StateGatewayComponent
    }
    fun stateGateway(): StateGatewayInterface
}