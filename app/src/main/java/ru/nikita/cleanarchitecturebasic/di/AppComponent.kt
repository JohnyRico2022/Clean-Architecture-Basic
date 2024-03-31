package ru.nikita.cleanarchitecturebasic.di

import dagger.Component
import ru.nikita.cleanarchitecturebasic.presentation.MainActivity


@Component(modules = [AppModule::class, DataModule::class, DomainModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}