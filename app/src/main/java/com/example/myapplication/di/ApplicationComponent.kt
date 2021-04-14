package com.example.myapplication.di

import com.example.myapplication.MyApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppAdapterModule::class,
        ApplicationModule::class,
        FrameworksModule::class,
        MainActivityModule::class,
        PokemonListFragmentModule::class,
        PokemonListModule::class]
)
interface ApplicationComponent: AndroidInjector<MyApplication> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: MyApplication): ApplicationComponent
    }
}