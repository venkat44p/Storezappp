package com.storezaap.ui.store

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.storezaap.data.store.StoreRepository

class StoreViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StoreViewModel::class.java)) {
            return StoreViewModel(storeRepository = StoreRepository()) as T
        }
        return super.create(modelClass)
    }
}