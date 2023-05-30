package com.storezaap.data.register

import com.google.gson.annotations.SerializedName
import com.storezaap.data.user.UserData

data class RegisterResponse(
    @SerializedName("response") val responseCode:Int,
    @SerializedName("message") val responseMessage:String,
    @SerializedName("status") val status:Boolean,
    @SerializedName("user") var data: UserData?=null
)