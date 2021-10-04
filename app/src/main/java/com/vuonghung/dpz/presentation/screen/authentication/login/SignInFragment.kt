package com.vuonghung.dpz.presentation.screen.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.R
import com.vuonghung.dpz.databinding.FragmentSignInBinding
import com.vuonghung.dpz.presentation.BaseFragment
import com.vuonghung.dpz.presentation.screen.authentication.AuthenticationActivity
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignInFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class SignInFragment : BaseFragment(), View.OnClickListener {
    private lateinit var viewBinding: FragmentSignInBinding
    private lateinit var naviController: NavController
    private val viewModel: LoginViewModel by viewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        naviController = this.findNavController()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
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
                naviController.navigate(R.id.act_signIn_to_home)
                (activity as AuthenticationActivity).finish()
            }

            R.id.btn_sign_up -> {
                naviController.navigate(R.id.act_sign_in_to_sign_up)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignInFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignInFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}