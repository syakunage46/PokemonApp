package com.example.myapplication.di

import com.example.core.navigation.NavigationStateElement
import com.example.myapplication.interface_adapters.gateway.ElementStreet
import com.example.myapplication.module.navigation.NavigationPresenter
import com.example.myapplication.module.navigation.NavigationPresenterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NavigationModule {

    @Singleton
    @Provides
    fun provideNavigationPresenter(navigationStreet: ElementStreet<NavigationStateElement>): NavigationPresenterInterface
            = NavigationPresenter(navigationStreet)
}