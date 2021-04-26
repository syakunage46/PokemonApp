package com.example.appadapter.di

import com.example.appadapter.AppAdapterGateway
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ReduxModule::class
])
interface AppAdapterGatewayComponent {
    fun inject(appAdapterGateway: AppAdapterGateway)
}