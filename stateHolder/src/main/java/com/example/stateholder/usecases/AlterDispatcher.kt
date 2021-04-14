package com.example.stateholder.usecases

import com.example.stateholder.entities.Alter
import com.example.stateholder.entities.AlterStateReceiver

interface AlterDispatcherInterface: AlterStateReceiver {
    val stateRecipient: StateRecipient
}

class AlterDispatcher(override val stateRecipient: StateRecipient) : AlterDispatcherInterface {

    override suspend fun dispatch(alter: Alter) {
        stateRecipient.dispatch(alter)
    }

}