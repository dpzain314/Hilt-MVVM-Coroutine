package com.vuonghung.dpz.data.repository

import com.vuonghung.dpz.data.remote.ApiHelper
import com.vuonghung.dpz.utils.performOperation
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {
    fun getUsers() = performOperation(networkCall = { apiHelper.getListUser() })
    fun loginApp() = performOperation(networkCall ={ apiHelper.getListUser() })
}