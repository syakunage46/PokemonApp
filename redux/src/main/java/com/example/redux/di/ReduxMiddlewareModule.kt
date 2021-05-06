package com.example.redux.di

import com.example.core.repository.Repository
import com.example.redux.middleware.ReduxMiddleware
import com.example.redux.middleware.ReduxMiddlewareManager
import com.example.redux.middleware.ReduxMiddlewareManagerInterface
import com.example.redux.middleware.Thunk
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ReduxMiddlewareModule {
    @Singleton
    @Provides
    fun provideReduxMiddlewareManager(middlewareList: List<@JvmSuppressWildcards ReduxMiddleware>): ReduxMiddlewareManagerInterface
        = ReduxMiddlewareManager(middlewareList)

    @Singleton
    @Provides
    fun provideMiddlewareList(repository: Repository): List<@JvmSuppressWildcards ReduxMiddleware> {
        return listOf(
            Thunk(repository)
        )
    }
}