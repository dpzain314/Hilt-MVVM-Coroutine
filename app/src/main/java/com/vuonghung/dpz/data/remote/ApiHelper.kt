package com.vuonghung.dpz.data.remote

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService): BaseDataSource() {
    suspend fun getListUser() = getResult { apiService.getUser() }
}