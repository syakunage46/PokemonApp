package com.example.redux.di

import com.example.redux.base_component.*
import com.example.redux.frameworks.EventInputConnector
import com.example.redux.frameworks.EventInputConnectorInterface
import com.example.redux.middleware.ReduxMiddlewareManagerInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ActionModule {
    @Singleton
    @Provides
    fun provideEventInputConnector(actionCreatorInterface: ActionCreatorInterface): EventInputConnectorInterface = EventInputConnector(actionCreatorInterface)

    @Singleton
    @Provides
    fun provideActionCreator(eventConverter: EventConverterInterface, dispatcher: DispatcherInterface): ActionCreatorInterface
            = ActionCreator(eventConverter, dispatcher)

    @Singleton
    @Provides
    fun provideDispatcher(store: StoreInterface, middlewareManager: ReduxMiddlewareManagerInterface): DispatcherInterface
            = Dispatcher(store, middlewareManager)
}