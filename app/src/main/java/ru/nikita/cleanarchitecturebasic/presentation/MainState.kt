package ru.nikita.cleanarchitecturebasic.presentation

data class MainState(
    val saveResult: Boolean,
    val firstName: String,
    val lastName: String
)