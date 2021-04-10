package com.example.stateholder.entities

import kotlinx.coroutines.flow.MutableStateFlow

class Alter(private val alter: (State) -> State){
    operator fun invoke(state: State): State = alter(state)
}

internal suspend fun MutableStateFlow<Alter?>.emit(alter: (State) -> State) = this.emit(Alter(alter))