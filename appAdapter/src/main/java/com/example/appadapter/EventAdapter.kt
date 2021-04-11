package com.example.appadapter

import com.example.myapplication.frameworks.EventCasterInterface
import com.example.stateholder.interfaseadapters.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

//interface EventAdapterInterface {
//    val eventCaster: EventCasterInterface
//    val eventFlow: Flow<Event>
//}
//
//class EventAdapter(
//    override val eventCaster: EventCasterInterface,
//): EventAdapterInterface {
//    override val eventFlow: Flow<Event> = eventCaster.eventFLow.map {
//        it as Event
//    }
//}