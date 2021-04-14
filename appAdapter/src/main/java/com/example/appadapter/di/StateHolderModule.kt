package com.example.appadapter.di

import android.app.Application
import com.example.core.event.Event
import com.example.core.state.State
import com.example.stateholder.StateGateway
import com.example.stateholder.StateGatewayInterface
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

typealias NonWildcardFlow<T> = Flow<@JvmSuppressWildcards T>

@Module
class StateHolderModule {

    @Singleton
    @Provides
    fun provideStateGateway(app: Application, eventFlow: NonWildcardFlow<Event>): StateGatewayInterface
            = StateGateway.getInstance(app, eventFlow)
    @Singleton
    @Provides
    fun provideStateFlow(stateGateway: StateGatewayInterface): NonWildcardFlow<State>
            = stateGateway.stateCaster.stateFLow
}