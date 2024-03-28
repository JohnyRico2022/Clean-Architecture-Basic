package ru.nikita.cleanarchitecturebasic.domain.repository

import ru.nikita.cleanarchitecturebasic.domain.model.SaveUserNameParam
import ru.nikita.cleanarchitecturebasic.domain.model.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}