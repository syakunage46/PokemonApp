package com.example.core.repository

abstract class Repository {
    suspend fun<T> fetch(query: RepositoryQuery<T>): Result<T> {
        return handle(query) as? Result<T> ?: Result.Failure(Exception("${this::class.simpleName}に${query::class.simpleName}でクエリすることができません"))
    }

    internal abstract suspend fun<T> handle(query: RepositoryQuery<T>): Result<*>?
}