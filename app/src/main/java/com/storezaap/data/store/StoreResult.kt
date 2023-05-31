package com.storezaap.data.store

import com.storezaap.data.user.UserData

data class StoreResult(
    val success: ArrayList<StoreItem>?=null, val error:String?=null
)
