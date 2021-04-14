package com.example.appadapter.converter

import com.example.myapplication.flux.Event

interface EventConverterInterface {
    operator fun invoke(event: Event): com.example.stateholder.interfaseadapters.Event
}

class EventConverter: EventConverterInterface {
    override operator fun invoke(event: Event): com.example.stateholder.interfaseadapters.Event {
        return when(event) {
            else -> {
                com.example.stateholder.interfaseadapters.Event.OnCreate()
            }
        }
    }
}