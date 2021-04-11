package com.example.myapplication.controller

import com.example.myapplication.flux.Event

interface EventReceiverInterface {
    fun event(event: Event)
}