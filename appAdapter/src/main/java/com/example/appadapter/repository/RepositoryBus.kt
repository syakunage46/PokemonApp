package com.example.appadapter.repository

import com.example.core.repository.Repository
import com.example.core.repository.RepositoryQuery
import com.example.core.repository.Result
import kotlin.reflect.KClass

interface RepositoryBusInterface

typealias Repositories = Map<KClass<out Repository<*>>, Repository<*>>

class RepositoryBus(private val repositoryList: List<Repository<*>>): RepositoryBusInterface {
    suspend fun <T> fetch(query: RepositoryQuery): Result<T> {
        repositoryList.first { it is Repository<query::class > }
    }
}