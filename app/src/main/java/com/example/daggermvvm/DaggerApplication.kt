package com.example.daggermvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DaggerApplication : Application() {


    override fun onCreate() {
        super.onCreate()
    }

}