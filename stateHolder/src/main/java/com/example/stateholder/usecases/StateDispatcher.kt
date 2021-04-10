package com.example.stateholder.usecases

import android.util.Log
import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.AlterStateReceiver
import com.example.stateholder.frameworks.EventListener
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

interface StateDispatcherInterface: AlterStateReceiver {
    val stateRecipient: StateRecipient
}

class StateDispatcher(override val alterFlow: Flow<Alter>,
                      override val stateRecipient: StateRecipient,
                      private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default) : StateDispatcherInterface {

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(EventListener.TAG, "error: ${throwable.localizedMessage}")
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    init {
        scope.launch {
            alterFlow.collect{
                stateRecipient.dispatch(it)
            }
        }
    }
    companion object {
        const val TAG = "StateDispatcher"
    }
}