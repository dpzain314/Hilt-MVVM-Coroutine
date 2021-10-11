package com.vuonghung.dpz.presentation.screen.authentication

import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.databinding.ActivityAuthenticationBinding
import com.vuonghung.dpz.presentation.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity: BaseActivity() {
    private lateinit var viewBinding: ActivityAuthenticationBinding

    override fun setViewBinding(): ViewBinding {
        viewBinding = ActivityAuthenticationBinding.inflate(layoutInflater)
        return viewBinding
    }

    override fun initial() {
        viewBinding.authentNavHost
    }

}