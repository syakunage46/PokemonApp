package com.example.stateholder.di

import android.app.Application
import com.example.core.event.Event
import com.example.stateholder.StateGatewayInterface
import dagger.BindsInstance
import dagger.Component
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
        AlterDispatcherModule::class,
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