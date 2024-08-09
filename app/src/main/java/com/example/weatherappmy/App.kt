package com.example.weatherappmy

import android.app.Application
import com.example.weatherappmy.di.component.AppComponent
import com.example.weatherappmy.di.component.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}