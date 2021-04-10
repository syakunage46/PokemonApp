package com.example.stateholder.usecases

import com.example.stateholder.entities.AlterStateReceiver

interface StateDispatcherInterFace: AlterStateReceiver

class StateDispatcher: StateDispatcherInterFace