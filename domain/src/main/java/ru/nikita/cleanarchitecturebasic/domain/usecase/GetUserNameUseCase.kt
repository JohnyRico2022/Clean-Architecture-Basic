package ru.nikita.cleanarchitecturebasic.domain.usecase

import ru.nikita.cleanarchitecturebasic.domain.model.UserName
import ru.nikita.cleanarchitecturebasic.domain.repository.UserRepository

class GetUserNameUseCase (private val userRepository: UserRepository){

    fun execute(): UserName {

        return userRepository.getName()
    }
}