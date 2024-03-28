package ru.nikita.cleanarchitecturebasic.data.storage

import ru.nikita.cleanarchitecturebasic.data.storage.madels.User

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User
}