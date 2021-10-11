package com.vuonghung.dpz.presentation.screen.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.R
import com.vuonghung.dpz.databinding.FragmentSignInBinding
import com.vuonghung.dpz.presentation.BaseFragment
import com.vuonghung.dpz.presentation.screen.authentication.AuthenticationActivity
import com.vuonghung.dpz.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment(), View.OnClickListener {
    private lateinit var viewBinding: FragmentSignInBinding
    private lateinit var naviController: NavController
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        naviController = this.findNavController()
        setupObserver()
    }

    private fun setupObserver(){
        viewModel.login?.observe(this, {
            when(it.status){
                Status.LOADING ->{

                }
                Status.ERROR ->{

                }
                Status.SUCCESS ->{
                    naviController.navigate(R.id.act_signIn_to_home)
                    (activity as AuthenticationActivity).finish()
                }
            }
        })
    }

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        viewBinding = FragmentSignInBinding.inflate(inflater, container, false)
        return viewBinding
    }

    override fun viewReadyToUse() {
        viewBinding.btnLogin.setOnClickListener(this)
        viewBinding.btnSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_login -> {
//                viewModel.getUser()
                naviController.navigate(R.id.act_signIn_to_home)
                (activity as AuthenticationActivity).finish()
            }

            R.id.btn_sign_up -> {
                naviController.navigate(R.id.act_sign_in_to_sign_up)
            }
        }
    }
}