package com.example.core.repository

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()

    data class Failure(val exception: Exception) : Result<Nothing>()

    val isSuccess get() = this is Success<T>

    val isFailure get() = this is Failure

    fun onSuccess(fn: (success: T) -> Unit): Result<T> =
        this.also { if (it is Result.Success) fn(it.data) }

    fun onFailure(fn: (failure: Exception) -> Unit): Result<T> =
        this.also { if (it is Result.Failure) fn(it.exception) }
}