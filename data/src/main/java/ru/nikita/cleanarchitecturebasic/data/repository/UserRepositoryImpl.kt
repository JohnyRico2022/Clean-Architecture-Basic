package ru.nikita.cleanarchitecturebasic.data.repository


import ru.nikita.cleanarchitecturebasic.data.storage.UserStorage
import ru.nikita.cleanarchitecturebasic.data.storage.madels.User
import ru.nikita.cleanarchitecturebasic.domain.model.SaveUserNameParam
import ru.nikita.cleanarchitecturebasic.domain.model.UserName
import ru.nikita.cleanarchitecturebasic.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return mapToDomain(user)
    }

    //Мапперы - перекладывают данные одной модели в другую
    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}