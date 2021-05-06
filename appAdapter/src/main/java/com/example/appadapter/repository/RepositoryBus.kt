package com.example.appadapter.repository

import com.example.core.repository.Repository
import com.example.core.repository.RepositoryRequest
import com.example.core.repository.Response
import kotlinx.coroutines.runBlocking
import kotlin.reflect.KClass

typealias Repositories = Map<KClass<out RepositoryRequest<*>>, Repository>

class RepositoryBus(private val repositories: Repositories): Repository() {
    override suspend fun<T, R: RepositoryRequest<T>> handle(request: R){
        val response = repositories[request::class]?.fetch(request) ?: Response.Failure(Exception("${request::class.simpleName}に対応するRepositoryが${this::class.simpleName}に登録されていません。"))
        request.response(response)
    }
}