package com.vuonghung.dpz.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment : Fragment(), View.OnClickListener{
    private lateinit var binding: ViewBinding

    abstract fun viewReadyToUse()
    abstract fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = setViewBinding(inflater,container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewReadyToUse()
    }
}