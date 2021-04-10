package com.example.myapplication.flux

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class Alter<StateType: State>(private val alter: (StateType) -> StateType){
    operator fun invoke(state: StateType): StateType = alter(state)
}

internal suspend fun <StateType: State> MutableStateFlow<Alter<StateType>?>.emit(alter: (StateType) -> StateType) = this.emit(Alter(alter))