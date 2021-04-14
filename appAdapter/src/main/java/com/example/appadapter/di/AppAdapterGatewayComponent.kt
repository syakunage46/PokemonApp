package com.example.appadapter.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import com.example.myapplication.frameworks.EventCaster
import com.example.myapplication.frameworks.EventCasterInterface
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AdapterModule::class,
    AppAdapterGatewayModule::class,
    ConverterModule::class,
    StateHolderModule::class
])
interface AppAdapterGatewayComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application, @BindsInstance eventCaster: EventCasterInterface): AppAdapterGatewayComponent
    }
    fun appAdapterGateway(): AppAdapterGateway
}