package com.vuonghung.dpz.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity: AppCompatActivity() {
    abstract fun initial()
    abstract fun setViewBinding(): ViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = setViewBinding().root
        setContentView(view)
        initial()
    }
}