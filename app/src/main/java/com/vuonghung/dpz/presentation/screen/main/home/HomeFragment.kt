package com.vuonghung.dpz.presentation.screen.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.R
import com.vuonghung.dpz.databinding.FragmentHomeBinding
import com.vuonghung.dpz.presentation.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : BaseFragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var navController: NavController
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = this.findNavController()
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onClick(view: View?) {
        when(view?.id){
            viewBinding.btnHome.id -> {
                navController.navigate(R.id.act_home_to_profile)
            }
        }
    }

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        viewBinding = FragmentHomeBinding.inflate(inflater,container,false)
        return viewBinding
    }

    override fun viewReadyToUse() {
        viewBinding.btnHome.setOnClickListener(this)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}