package com.example.stateholder.usecases

import com.example.stateholder.entities.Alter

interface StateRecipient {
    suspend fun dispatch(alter: Alter)
}