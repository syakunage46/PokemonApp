package com.example.core.util

import kotlinx.coroutines.flow.Flow

typealias NonWildcardFlow<T> = Flow<@JvmSuppressWildcards T>