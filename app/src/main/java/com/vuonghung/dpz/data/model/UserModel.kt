package com.vuonghung.dpz.data.model

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("name")
    var name: String,
    @SerializedName("id")
    var id: Int){

}