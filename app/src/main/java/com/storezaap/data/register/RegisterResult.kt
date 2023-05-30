package com.storezaap.data.register

import com.storezaap.data.user.UserData


data class RegisterResult(
    val success: UserData?=null, val error:String?=null
)
