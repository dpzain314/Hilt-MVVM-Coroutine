package com.vuonghung.dpz.presentation.screen.main.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.databinding.FragmentProfileBinding
import com.vuonghung.dpz.presentation.BaseFragment

class ProfileFragment : BaseFragment() {
    private lateinit var viewBinding: FragmentProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onClick(p0: View?) {
    }

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        viewBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return viewBinding
    }

    override fun viewReadyToUse() {
        viewBinding.btnProfile.text =
            arguments?.let { ProfileFragmentArgs.fromBundle(it).username.name }
    }
}