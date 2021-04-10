package com.example.stateholder.di

import kotlinx.coroutines.flow.Flow

typealias NonWildcardFlow<T> = Flow<@JvmSuppressWildcards T>