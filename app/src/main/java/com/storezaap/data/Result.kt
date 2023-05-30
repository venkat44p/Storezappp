package com.storezaap.data

sealed class Result<out T:Any>{
    data class Success<out T:Any>(val data:T):com.storezaap.data.Result<T>()
    data class Error(val errorMessage:String):com.storezaap.data.Result<Nothing>()

    override fun toString(): String {
        return when(this){
            is Success<*> -> "Success[data=$data]"
            is Error-> "Error[errorMessage=$errorMessage]"
        }
    }

}
