package com.example.stateholder.usecases

import com.example.stateholder.entities.Alter
import kotlinx.coroutines.flow.Flow

interface StateRecipient {
    suspend fun dispatch(alter: Alter)
}