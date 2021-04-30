package com.example.core.repository

import kotlinx.coroutines.runBlocking

//abstract class Repository {
//    suspend fun<T, Q: RepositoryQuery<T>> fetch(parcel: RepositoryParcel<T, Q>): Result<T> {
////        val result = Result<T>()
//        return handle(parcel) as? Result<T> ?: Result.Failure(Exception("${this::class.simpleName}に${parcel::class.simpleName}でクエリすることができません"))
//    }
//
//    //internal abstract suspend fun<T> handle(parcel: RepositoryParcel<T>): Result<*>?
//}

class TestQuery: RepositoryQuery<String> {
    val test: String = "test"
}

class TestRepository {
    inline fun<reified T, Q: RepositoryQuery<T>> fetch(query: Q): Result<T> {
        val parcel = RepositoryParcel(query)
        parcel.result = Result.Failure(Exception("${this::class.simpleName}に${query::class.simpleName}でクエリすることができません")) as Result<T>
        return handle(parcel).result
    }

    inline fun<reified T, Q: RepositoryQuery<T>, P: RepositoryParcel<T, Q>> handle(parcel: P): P{
        val success = "Success"
        if(parcel.query is TestQuery && success is T){
            parcel.result = Result.Success(success)
        }

        return parcel
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