package com.example.myapplication.di

import android.app.Application
import com.example.myapplication.MyApplication
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class ApplicationModule {
    @Binds
    abstract fun provideContext(application: MyApplication): Application
}