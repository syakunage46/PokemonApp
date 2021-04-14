package com.example.myapplication.controller

import com.example.core.event.Event

interface EventReceiverInterface {
    fun event(event: Event)
}