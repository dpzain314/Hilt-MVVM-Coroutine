package com.vuonghung.dpz.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserModel(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("phone")
    val phone: String = ""
):Serializable
