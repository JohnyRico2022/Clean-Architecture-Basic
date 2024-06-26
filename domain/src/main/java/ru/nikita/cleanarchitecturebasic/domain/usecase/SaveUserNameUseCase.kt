package ru.nikita.cleanarchitecturebasic.domain.usecase

import ru.nikita.cleanarchitecturebasic.domain.model.SaveUserNameParam
import ru.nikita.cleanarchitecturebasic.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository){

    fun execute(param: SaveUserNameParam): Boolean {
        val oldUserName = userRepository.getName()

        if (oldUserName.firstName == param.name) {
            return true
        }

        val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}