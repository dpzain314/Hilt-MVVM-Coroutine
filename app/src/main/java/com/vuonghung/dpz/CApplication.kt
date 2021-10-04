package com.vuonghung.dpz

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}