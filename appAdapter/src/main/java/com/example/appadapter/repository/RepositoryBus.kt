package com.example.appadapter.repository

import com.example.core.repository.Repository
import com.example.core.repository.RepositoryParcel
import com.example.core.repository.Result
import java.lang.Exception
import kotlin.reflect.KClass

typealias Repositories = Map<KClass<out RepositoryParcel<*>>, Repository>

class RepositoryBus(val repositoryList: Repositories): Repository() {
    inline operator fun<reified Key: RepositoryParcel<*>> get(key: KClass<Key>):Key? = repositoryList[key] as? Key

    internal override suspend fun<T> handle(parcel: RepositoryParcel<T>): Result<*>? {
        return repositoryList[parcel::class]?.fetch(parcel) ?: Result.Failure(Exception("${parcel}を扱うRepositoryがRepositoryBusに登録されていません"))
    }
}