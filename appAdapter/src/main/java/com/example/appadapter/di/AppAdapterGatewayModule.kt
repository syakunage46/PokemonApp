package com.example.appadapter.di

import com.example.appadapter.AppAdapterGateway
import com.example.appadapter.AppAdapterGatewayInterface
import com.example.appadapter.adapter.EventAdapterInterface
import com.example.appadapter.adapter.StateAdapterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppAdapterGatewayModule {
    @Singleton
    @Provides
    fun provideAppAdapterGateway(eventAdapter: EventAdapterInterface, stateAdapter: StateAdapterInterface):  AppAdapterGatewayInterface
            =  AppAdapterGateway(eventAdapter, stateAdapter)
}