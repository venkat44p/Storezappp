package com.storezaap.data.login

import com.storezaap.data.DataHelper
import com.storezaap.data.Result
import com.storezaap.data.user.UserData
import com.storezaap.data.apis.RetrofitClient
import com.storezaap.utils.StatusCodes
import com.storezaap.utils.logE

class LoginRepository {

    suspend fun login(loginRequest: LoginRequest): Result<UserData> {
        var msg = ""
        var userData: UserData? = null
        val response = RetrofitClient.api.login(loginRequest = loginRequest)
        return try {

            if (response.isSuccessful && response.code() == StatusCodes.OK) {
                val body = response.body()
                if (body != null) {
                    if (body.responseCode == StatusCodes.OK) {
                        userData = body.data!!
                        DataHelper.user = userData
                    } else {
                        msg = body.responseMessage
                    }
                }
            }

            Result.Success(userData!!)
        } catch (e: Exception) {
            logE(TAG, e)
            Result.Error(msg)
        }
    }

    companion object {
        const val TAG = "LoginRepository"
    }

}