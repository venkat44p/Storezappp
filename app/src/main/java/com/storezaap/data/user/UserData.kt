package com.storezaap.data.user

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName(ID) val id:Int,
    @SerializedName(NAME) val name:String?,
    @SerializedName(EMAIL) val email:String?,
    @SerializedName(PROFILE_PIC_URL) val picUrl:String?
    )
{
    companion object{
        const val ID="id"
        const val EMAIL="id"
        const val NAME="id"
        const val PROFILE_PIC_URL="id"
    }
}