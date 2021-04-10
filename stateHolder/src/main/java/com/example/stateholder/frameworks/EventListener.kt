package com.example.stateholder.frameworks

import android.util.Log
import com.example.stateholder.interfaseadapters.Event
import com.example.stateholder.interfaseadapters.EventControllerInterface
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

interface EventListenerInterface {
    val eventFlow: Flow<Event>
    fun dispose()
}

class EventListener(override val eventFlow: Flow<Event>,
                    private val controller: EventControllerInterface,
                    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default): EventListenerInterface {

    private val exceptionHandler: CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.e(TAG, "error: ${throwable.localizedMessage}")
    }
    private val job = SupervisorJob()
    private val scope = CoroutineScope(coroutineDispatcher + job + exceptionHandler)

    init {
        scope.launch {
            eventFlow.collect{controller.event(it)}
        }
    }

    override fun dispose() {
        job.cancel()
    }

    companion object {
        const val TAG = "EventListener"
    }
}