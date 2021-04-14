package com.example.myapplication.flux

import kotlinx.coroutines.flow.MutableStateFlow

class Alter<StateType>(private val alter: (StateType) -> StateType){
    operator fun invoke(state: StateType): StateType = alter(state)
}

internal suspend fun MutableStateFlow<Alter<State>?>.emit(alter: (State) -> State) = this.emit(Alter(alter))