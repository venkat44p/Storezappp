package com.storezaap.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.storezaap.data.login.LoginRepository

class LoginViewModelFactory constructor(private val loginRepository: LoginRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(loginRepository = loginRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}