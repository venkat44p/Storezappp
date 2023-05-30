package com.storezaap.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.storezaap.data.register.RegisterRepository

class RegisterViewModelFactory constructor(private val registerRepository: RegisterRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(registerRepository = registerRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}