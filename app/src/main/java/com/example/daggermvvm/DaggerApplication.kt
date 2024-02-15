package com.example.daggermvvm

import android.app.Application
import com.example.daggermvvm.di.ApplicationComponent
import com.example.daggermvvm.di.DaggerApplicationComponent


class DaggerApplication : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.factory().create(this)
    }

}