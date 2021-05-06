package com.example.core.repository

abstract class Repository {
    suspend fun<T> fetch(request: RepositoryRequest<T>): Response<T> {
        request.failure(Exception("${this::class.simpleName}に${request::class.simpleName}でリクエストすることができません"))
        handle(request)
        return request.response
    }

    protected abstract suspend fun<T, R: RepositoryRequest<T>> handle(request: R)
}