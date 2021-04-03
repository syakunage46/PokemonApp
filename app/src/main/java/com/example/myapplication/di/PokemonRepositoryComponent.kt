package com.example.myapplication.di

import com.example.myapplication.MainActivityViewModel
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    PokemonRepositoryGatewayModule::class])
interface PokemonRepositoryComponent {
    fun inject(mainViewModel: MainActivityViewModel)
}