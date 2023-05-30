package com.storezaap.data.register

import com.google.gson.annotations.SerializedName

class RegisterRequest(
    @SerializedName("name") val name:String?,
    @SerializedName("email") val email:String?,
    @SerializedName("password") val password:String?
)

