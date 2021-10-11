package com.vuonghung.dpz.presentation.screen.authentication.register

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.databinding.FragmentSignUpBinding
import com.vuonghung.dpz.presentation.BaseFragment

class SignUpFragment : BaseFragment() {
    private lateinit var viewBinding:ViewBinding

    override fun onClick(p0: View?) {}

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        viewBinding = FragmentSignUpBinding.inflate(inflater,container,false)
        return viewBinding
    }

    override fun viewReadyToUse() {}
}