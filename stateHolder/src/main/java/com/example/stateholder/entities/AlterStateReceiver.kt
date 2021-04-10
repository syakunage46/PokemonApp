package com.example.stateholder.entities

import kotlinx.coroutines.flow.Flow

interface AlterStateReceiver {
    val alterFlow: Flow<Alter>
}