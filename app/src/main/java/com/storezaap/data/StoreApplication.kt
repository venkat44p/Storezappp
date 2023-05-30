package com.storezaap.data

import android.app.Application

class StoreApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        DataHelper.initialize(this)
    }

}