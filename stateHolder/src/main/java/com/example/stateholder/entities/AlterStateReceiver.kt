package com.example.stateholder.entities

interface AlterStateReceiver {
    suspend fun dispatch(alter: Alter)
}