package com.example.appadapter.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import com.example.core.event.Event
import com.example.stateholder.di.StateGatewayComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ReduxModule::class,
    RepositoryBusModule::class
])
interface AppAdapterGatewayComponent {
    fun inject(appAdapterGateway: AppAdapterGateway)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppAdapterGatewayComponent
    }
}