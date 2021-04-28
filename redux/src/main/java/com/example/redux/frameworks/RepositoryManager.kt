package com.example.redux.frameworks

import com.example.core.repository.Repository
import kotlin.reflect.KClass

typealias Repositories = Map<KClass<out Repository>, Repository>

class RepositoryManager(val repositories: Repositories) {
    inline operator fun<reified Key: Repository> get(key: KClass<Key>):Key? = repositories[key] as? Key
}