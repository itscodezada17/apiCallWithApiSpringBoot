package com.ujjwal.spacex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber
import timber.log.Timber.Forest.plant


@HiltAndroidApp
class MyApplication: Application(){
    override fun onCreate() {
        super.onCreate()

        // This will initialize Timber
        plant(Timber.DebugTree())
    }
}