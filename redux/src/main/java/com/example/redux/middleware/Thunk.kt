package com.example.redux.middleware

import com.example.core.repository.Repository
import com.example.redux.base_component.Action
import com.example.redux.base_component.StoreInterface
import com.example.redux.frameworks.RepositoryManager
import kotlinx.coroutines.*

interface ThunkAction: Action {
    fun start(): Action
    suspend operator fun invoke(store: StoreInterface, repository: Repository): Action
}

class Thunk(private val repository: Repository, private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default): ReduxMiddleware {
    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        throw throwable
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    override fun behavior(store: StoreInterface, next: ReduxMiddlewareNext, action: Action): Action {
        val result = if (action is ThunkAction) next(action.start()) else return next(action)
        scope.launch {
            // TODO: MiddlewareにDispatcherとStateを渡すようにすればいいと思う
            store.dispatch(action(store, repository))s
        }
        return next(result)
    }
}