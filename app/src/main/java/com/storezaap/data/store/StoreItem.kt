package com.storezaap.data.store

import com.google.gson.annotations.SerializedName

data class StoreItem(
   @SerializedName("Image") val image: String,
   @SerializedName("Heading") val heading: String,
   @SerializedName("Text") val desc: String,
   @SerializedName("Offer") val offer: String,
   @SerializedName("Button") val btnText: String,
   @SerializedName("URL") val redirectUrl: String
)
