package com.example.redux.frameworks

import com.example.core.repository.Repository
import com.example.core.repository.RepositoryParcel
import com.example.core.repository.Result

interface ActionRepositoryInterface: Repository

class ActionRepository(val repository: ): ActionRepositoryInterface {


    override suspend fun <T> fetch(parcel: RepositoryParcel): Result<T> {
        TODO("Not yet implemented")
    }

}