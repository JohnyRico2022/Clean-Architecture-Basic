package ru.nikita.cleanarchitecturebasic.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.nikita.cleanarchitecturebasic.data.repository.UserRepositoryImpl
import ru.nikita.cleanarchitecturebasic.data.storage.UserStorage
import ru.nikita.cleanarchitecturebasic.data.storage.sharedprefs.SharedPrefUserStorage
import ru.nikita.cleanarchitecturebasic.domain.repository.UserRepository

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)

    }
}
