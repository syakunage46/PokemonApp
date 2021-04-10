package com.example.stateholder.interfaseadapters

sealed  class Event {
    class OnCreate: Event()
    class OnSwipeRefresh : Event()
    class OnScrolledToEnd(val offset: Int) : Event()
}