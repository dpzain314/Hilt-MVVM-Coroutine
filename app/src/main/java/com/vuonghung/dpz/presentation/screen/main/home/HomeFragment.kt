package com.vuonghung.dpz.presentation.screen.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.vuonghung.dpz.data.model.UserModel
import com.vuonghung.dpz.databinding.FragmentHomeBinding
import com.vuonghung.dpz.presentation.BaseFragment
import com.vuonghung.dpz.presentation.adapter.ListUserAdapter
import com.vuonghung.dpz.utils.Status
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment(),ListUserAdapter.ItemListListener {
    private lateinit var viewBinding: FragmentHomeBinding
    private lateinit var navController: NavController
    private val homeViewModel:HomeViewModel by viewModels()
    @Inject
    lateinit var listUserAdapter: ListUserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = this.findNavController()
    }

    override fun viewReadyToUse() {
        setupUI()
        setupObserver()
    }

    private fun setupUI(){
        viewBinding.listUser.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        viewBinding.listUser.adapter = listUserAdapter
        listUserAdapter.setOnClickListener(this)
    }

    override fun onItemClick(user : UserModel) {
        val action = HomeFragmentDirections.actHomeToProfile(user)
        navController.navigate(action)// action nav
    }

    private fun setupObserver(){
        homeViewModel.getListUser()
        homeViewModel.listUser?.observe(this,{
            when(it.status){
                Status.LOADING ->{
                    viewBinding.progressBar.visibility = View.VISIBLE
                    viewBinding.listUser.visibility = View.GONE
                }
                Status.SUCCESS ->{
                    it.data?.let { users -> renderList(users.data!!) }
                    viewBinding.listUser.visibility = View.VISIBLE
                    viewBinding.progressBar.visibility = View.GONE
                }
                Status.ERROR ->{
                    viewBinding.progressBar.visibility = View.GONE
                }
            }
        })
    }

    private fun renderList(users: List<UserModel>) {
        listUserAdapter.addNewData(users)
    }

    override fun onClick(view: View?) {
//        when (view?.id) {
//            viewBinding.btnHome.id -> {
//                navController.navigate(R.id.act_home_to_profile)
//            }
//        }
    }

    override fun setViewBinding(inflater: LayoutInflater, container: ViewGroup?): ViewBinding {
        viewBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return viewBinding
    }
}