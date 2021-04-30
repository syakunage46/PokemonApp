package com.example.core.repository

import kotlinx.coroutines.runBlocking

abstract class Repository {
    suspend fun<T> fetch(query: RepositoryQuery<T>): Result<T> {
        return handle(query) as? Result<T> ?: Result.Failure(Exception("${this::class.simpleName}に${query::class.simpleName}でクエリすることができません"))
    }

    internal abstract suspend fun<T> handle(query: RepositoryQuery<T>): Result<*>?
}

class TestQuery : RepositoryQuery<String> {
    val test: String = "test"
}

class TestRepository: Repository() {
    override suspend fun<T> handle(query: RepositoryQuery<T>): Result<*>? {
        return when(query) {
            is TestQuery -> query.answer("Success")
            else -> null
        }
    }
}


fun main() {
    val repository = TestRepository()
    runBlocking {
        val test = repository.fetch(TestQuery())
        print(test)
        test.onSuccess {
            print(it)
        }
    }

}