package com.example.appadapter.di

import com.example.appadapter.AppAdapterGateway
import com.example.appadapter.AppAdapterGatewayInterface
import com.example.core.state.State
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Module
class AppAdapterGatewayModule {
    @Singleton
    @Provides
    fun provideAppAdapterGateway(stateFlow: NonWildcardFlow<State>): AppAdapterGatewayInterface
            =  AppAdapterGateway(stateFlow)
}