package com.example.core.repository

sealed class Response<out T> {

    data class Success<out T>(val data: T) : Response<T>()

    data class Failure(val exception: Exception) : Response<Nothing>()

    val isSuccess get() = this is Success<T>

    val isFailure get() = this is Failure

    fun onSuccess(fn: (success: T) -> Unit): Response<T> =
        this.also { if (it is Response.Success) fn(it.data) }

    fun onFailure(fn: (failure: Exception) -> Unit): Response<T> =
        this.also { if (it is Response.Failure) fn(it.exception) }
}