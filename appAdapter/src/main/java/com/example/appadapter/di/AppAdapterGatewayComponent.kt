package com.example.appadapter.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import com.example.stateholder.entities.State
import dagger.BindsInstance
import dagger.Component
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppAdapterGatewayModule::class,
    ConverterModule::class,
    StateHolderModule::class
])
interface AppAdapterGatewayComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application, @BindsInstance stateFlow: Flow<State>): AppAdapterGatewayComponent
    }
    fun appAdapterGateway(): AppAdapterGateway
}