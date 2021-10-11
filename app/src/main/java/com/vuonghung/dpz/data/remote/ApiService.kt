package com.vuonghung.dpz.data.remote

import com.vuonghung.dpz.data.model.BaseResponse
import com.vuonghung.dpz.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUser(): Response<BaseResponse<UserModel>>
}