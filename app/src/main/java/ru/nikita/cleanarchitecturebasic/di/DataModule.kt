package ru.nikita.cleanarchitecturebasic.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.nikita.cleanarchitecturebasic.data.repository.UserRepositoryImpl
import ru.nikita.cleanarchitecturebasic.data.storage.UserStorage
import ru.nikita.cleanarchitecturebasic.data.storage.sharedprefs.SharedPrefUserStorage
import ru.nikita.cleanarchitecturebasic.domain.repository.UserRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}