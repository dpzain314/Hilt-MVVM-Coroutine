package com.vuonghung.dpz.presentation.screen.main

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.databinding.ActivityMainBinding
import com.vuonghung.dpz.presentation.BaseActivity
import com.vuonghung.dpz.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun setViewBinding(): ViewBinding {
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        return viewBinding
    }

    override fun initial() {
        setupObserver()
    }

    private fun setupObserver(){
        viewModel.listUsers.observe(this, Observer {
            when (it.status){
                Status.LOADING ->{}
                Status.SUCCESS ->{}
                Status.ERROR ->{}
            }
        })
    }

}