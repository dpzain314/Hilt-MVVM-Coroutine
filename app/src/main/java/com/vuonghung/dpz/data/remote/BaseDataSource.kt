package com.vuonghung.dpz.data.remote

import android.util.Log
import com.vuonghung.dpz.utils.Resource
import com.vuonghung.dpz.utils.network.ConnectNetworkManager
import retrofit2.Response
import timber.log.Timber
import java.util.logging.Logger
import javax.inject.Inject

abstract class BaseDataSource {
    @Inject
    lateinit var connectivity : ConnectNetworkManager

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        if(connectivity.isNetworkConnected()) {
            try {
                val response = call()
                if (response.isSuccessful) {
                    val body = response.body()
                    if (body != null) return Resource.success(body)
                }
                return error(" ${response.code()} ${response.message()}")
            } catch (e: Exception) {
                return error(e.message ?: e.toString())
            }
        }else{
            return error("Network connection failed!")
        }
    }

    private fun <T> error(message: String): Resource<T> {
        Timber.d(message)
        return Resource.error("Error: $message")
    }
}