package com.vuonghung.dpz.data.model

import com.google.gson.annotations.SerializedName

open class BaseResponse<T>(
//    @SerializedName("status")
//    var status: String? = "",
//    @SerializedName("message")
//    var message: String? = "",
    @SerializedName("items")
    var data: List<T>? = null,
)