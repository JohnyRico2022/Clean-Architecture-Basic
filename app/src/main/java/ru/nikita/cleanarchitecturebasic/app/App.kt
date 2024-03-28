package ru.nikita.cleanarchitecturebasic.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.nikita.cleanarchitecturebasic.di.appModule
import ru.nikita.cleanarchitecturebasic.di.dataModule
import ru.nikita.cleanarchitecturebasic.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}