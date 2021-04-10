package com.example.stateholder.entities

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull

interface AlterCreatorInterface {
    val alterFlow: Flow<Alter>
    suspend fun create(action: Action)
}

class AlterCreator: AlterCreatorInterface {
    private val _alterFlow = MutableStateFlow<Alter?>(null)
    override val alterFlow = _alterFlow.filterNotNull()
    override suspend fun create(action: Action) {
        when(action) {
            is PokemonAction.GetList -> {
                _alterFlow.emit { state ->
                    state
                }
            }
        }
    }
}