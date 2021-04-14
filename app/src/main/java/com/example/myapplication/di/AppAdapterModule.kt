package com.example.myapplication.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import com.example.appadapter.AppAdapterGatewayInterface
import com.example.core.event.Event
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppAdapterModule {
    @Singleton
    @Provides
    fun provideAppAdapter(app: Application, eventFlow: NonWildcardFlow<Event>): AppAdapterGatewayInterface
            = AppAdapterGateway.getInstance(app, eventFlow)

}