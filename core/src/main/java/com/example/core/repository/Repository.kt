package com.example.core.repository

import kotlinx.coroutines.runBlocking

abstract class Repository {
    suspend fun<T> fetch(query: RepositoryQuery<T>): Result<T> {
        return handle(query) as? Result<T> ?: Result.Failure(Exception("${this::class.simpleName}は${query::class.simpleName}に対応していません"))
    }

    internal abstract suspend fun handle(query: RepositoryQuery<*>): Result<*>?
}

class TestQuery: RepositoryQuery<String> {
    val test: String = "test"
}

class TestRepository : Repository() {
    override suspend fun handle(query: RepositoryQuery<*>): Result<*>? {
        return when(query) {
            is TestQuery -> {
                Result.Success("Success!")
            }
            else -> null
        }
    }
}


fun main() {
    val repository = TestRepository()
    runBlocking {
        val test = repository.fetch<String>(TestQuery())
        print(test)
        test.onSuccess {
            print(it)
        }
    }

}