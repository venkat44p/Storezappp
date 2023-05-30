package com.storezaap.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.storezaap.data.login.LoginRepository
import com.storezaap.data.login.LoginRequest
import com.storezaap.data.login.LoginResult
import kotlinx.coroutines.launch

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private var _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val result = loginRepository.login(loginRequest = loginRequest)

            if (result is com.storezaap.data.Result.Success) {
                _loginResult.value = LoginResult(success = result.data)
            } else if (result is com.storezaap.data.Result.Error) {
                _loginResult.value = LoginResult(error = result.errorMessage)
            }

        }
    }

}