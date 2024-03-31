package ru.nikita.cleanarchitecturebasic.app

import android.app.Application
import ru.nikita.cleanarchitecturebasic.di.AppComponent
import ru.nikita.cleanarchitecturebasic.di.AppModule
import ru.nikita.cleanarchitecturebasic.di.DaggerAppComponent


class App:Application() {

    lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }

}