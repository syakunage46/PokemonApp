package com.example.myapplication.di

import com.example.appadapter.AppAdapterGatewayInterface
import com.example.myapplication.flux.State
import com.example.myapplication.frameworks.EventCaster
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.myapplication.frameworks.StateListener
import com.example.myapplication.frameworks.StateListenerInterface
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

typealias NonWildcardFlow<T> = Flow<@JvmSuppressWildcards T>

@Module
class FrameworksModule{
    @Singleton
    @Provides
    fun provideEventCaster(): EventCasterInterface
            = EventCaster()
    @Singleton
    @Provides
    fun provideStateFlow(appAdapter: AppAdapterGatewayInterface): NonWildcardFlow<State>
            = appAdapter.stateAdapter.stateFlow
    @Singleton
    @Provides
    fun provideStateListener(stateFlow: NonWildcardFlow<State>): StateListenerInterface
            = StateListener(stateFlow)
}