package com.example.stateholder.entities

import kotlinx.coroutines.flow.Flow

interface AlterStateReceiver {
    suspend fun dispatch(alter: Alter)
}