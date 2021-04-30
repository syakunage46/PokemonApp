package com.example.core.repository

interface RepositoryQuery<Wish> {
    fun answer(result: Wish): Result<Wish> = Result.Success(result)
}

