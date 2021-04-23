package com.example.myapplication.interface_adapters.controller

import com.example.core.event.Event

interface EventReceiverInterface {
    fun send(event: Event)
}