package com.example.stateholder.usecases.actionplan

import com.example.stateholder.entities.AlterCreatorInterFace

interface ActionPlan {
    val alterCreator: AlterCreatorInterFace
    suspend operator fun invoke()
}