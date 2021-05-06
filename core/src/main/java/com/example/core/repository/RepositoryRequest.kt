package com.example.core.repository

// ジェネリクスをきかせるためにRequestの中にresultがある。あまり良くない
abstract class RepositoryRequest<T> {
    lateinit var response: Response<T>
        private set

    fun response(response: Response<T>) {
        this.response = response
    }

    fun success(response: T) {
        this.response = Response.Success(response)
    }

    fun failure(exception: Exception) {
        this.response = Response.Failure(exception)
    }
}