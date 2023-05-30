package com.storezaap.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.storezaap.data.register.RegisterRepository
import com.storezaap.data.register.RegisterRequest
import com.storezaap.data.register.RegisterResult
import kotlinx.coroutines.launch


class RegisterViewModel(private val registerRepository: RegisterRepository) : ViewModel() {

    private var _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    fun login(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val result = registerRepository.register(registerRequest = registerRequest)

            if (result is com.storezaap.data.Result.Success) {
                _registerResult.value = RegisterResult(success = result.data)
            } else if (result is com.storezaap.data.Result.Error) {
                _registerResult.value = RegisterResult(error = result.errorMessage)
            }

        }
    }

}