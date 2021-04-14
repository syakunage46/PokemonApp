package com.example.myapplication.di

import android.app.Application
import com.example.appadapter.AppAdapterGateway
import com.example.appadapter.AppAdapterGatewayInterface
import com.example.myapplication.frameworks.EventCasterInterface
import com.example.myapplication.module.pokemonlist.PokemonListControllerService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppAdapterModule {
    @Singleton
    @Provides
    fun provideAppAdapter(app: Application, eventCaster: EventCasterInterface): AppAdapterGatewayInterface
            = AppAdapterGateway.getInstance(app, eventCaster)

}