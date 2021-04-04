package com.example.myapplication.flux

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class Store<StateDataType>(
    private val dispatcher: Dispatcher<*, StateDataType>,
    ): ViewModel() {
    abstract val state: LiveData<StateDataType>
}