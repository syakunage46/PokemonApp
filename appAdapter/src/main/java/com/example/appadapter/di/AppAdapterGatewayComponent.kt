package com.example.appadapter.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    EventConverterBusModule::class,
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