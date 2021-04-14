package com.example.appadapter.di

import com.example.appadapter.AppAdapterGateway
import com.example.appadapter.AppAdapterGatewayInterface
import com.example.stateholder.entities.State
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
class AppAdapterGatewayModule {
    @Singleton
    @Provides
    fun provideAppAdapterGateway(stateFlow: Flow<State>):  AppAdapterGatewayInterface
            =  AppAdapterGateway(stateFlow)
}