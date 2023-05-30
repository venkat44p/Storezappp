package com.storezaap.data.login

import com.storezaap.data.user.UserData

data class LoginResult(
    val success: UserData?=null, val error:String?=null
)
