package ru.nikita.cleanarchitecturebasic.presentation

interface MainEvent

class SaveEvent(val text: String) : MainEvent

class LoadEvent : MainEvent
