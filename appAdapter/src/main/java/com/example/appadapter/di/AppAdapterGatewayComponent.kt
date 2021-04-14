package com.example.appadapter.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import com.example.core.event.Event
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppAdapterGatewayModule::class,
    StateHolderModule::class
])
interface AppAdapterGatewayComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application, @BindsInstance eventFlow: NonWildcardFlow<Event>): AppAdapterGatewayComponent
    }
    fun appAdapterGateway(): AppAdapterGateway
}