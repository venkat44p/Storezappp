package com.storezaap.ui.store

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.storezaap.data.store.StoreRepository
import com.storezaap.data.store.StoreResult
import kotlinx.coroutines.launch

class StoreViewModel constructor(private val storeRepository: StoreRepository) : ViewModel() {

    private var _storeData = MutableLiveData<StoreResult>()
     var storeData: LiveData<StoreResult> = _storeData

    fun getStoreData(category: String) {
        viewModelScope.launch {
            val result = storeRepository.storeData(category)

            if (result is com.storezaap.data.Result.Success) {
                _storeData.value = StoreResult(success = result.data)
            } else if (result is com.storezaap.data.Result.Error) {
                _storeData.value = StoreResult(error = result.errorMessage)
            }

        }
    }

}