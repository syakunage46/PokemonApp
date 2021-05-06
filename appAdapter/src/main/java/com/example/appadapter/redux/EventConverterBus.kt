package com.example.appadapter.redux

import com.example.core.event.Event
import com.example.redux.base_component.Action
import com.example.redux.base_component.EventConverterInterface
import kotlin.reflect.KClass

typealias EventConverters = Map<KClass<out Event>, EventConverterInterface>

class MissingEventConverter: Action

class EventConverterBus(private val eventConverters: EventConverters): EventConverterInterface {
    override fun convert(event: Event): Action {
        return eventConverters[event::class]?.convert(event) ?: MissingEventConverter()
    }
}