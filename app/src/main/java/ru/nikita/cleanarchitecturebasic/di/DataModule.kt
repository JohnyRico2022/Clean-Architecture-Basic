package ru.nikita.cleanarchitecturebasic.di

import org.koin.dsl.module
import ru.nikita.cleanarchitecturebasic.data.repository.UserRepositoryImpl
import ru.nikita.cleanarchitecturebasic.data.storage.UserStorage
import ru.nikita.cleanarchitecturebasic.data.storage.sharedprefs.SharedPrefUserStorage
import ru.nikita.cleanarchitecturebasic.domain.repository.UserRepository

val dataModule = module {

    single<UserStorage> {
        SharedPrefUserStorage(context = get())
    }

    single<UserRepository> {
        UserRepositoryImpl(userStorage = get())
    }
}