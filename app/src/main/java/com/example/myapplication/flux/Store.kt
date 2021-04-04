package com.example.myapplication.flux

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow

abstract class Store<StateType>(
    private val dispatcher: Dispatcher<*, StateType>,
    ): ViewModel() {
    abstract val state: LiveData<StateType>
}