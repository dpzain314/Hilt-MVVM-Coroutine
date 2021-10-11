package com.vuonghung.dpz

import android.app.Application
import androidx.viewbinding.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CApplication: Application() {
    override fun onCreate() {
        super.onCreate()

    }
}