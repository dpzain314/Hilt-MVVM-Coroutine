package com.vuonghung.dpz.presentation.screen.main.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vuonghung.dpz.data.model.BaseResponse
import com.vuonghung.dpz.data.model.UserModel
import com.vuonghung.dpz.data.repository.MainRepository
import com.vuonghung.dpz.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val mainRepository: MainRepository): ViewModel() {
    var listUser : LiveData<Resource<BaseResponse<UserModel>>>? = null

    fun getListUser() {
        listUser = mainRepository.getUsers()
    }

}