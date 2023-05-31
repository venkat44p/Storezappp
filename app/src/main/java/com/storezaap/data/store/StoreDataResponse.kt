package com.storezaap.data.store

import com.google.gson.annotations.SerializedName

data class StoreDataResponse(
  @SerializedName("error")  val responseCode: Int,
  @SerializedName("Sidebrand")  val amazon: ArrayList<StoreItem>,
  @SerializedName("Ebay_brand")  val ebay: ArrayList<StoreItem>,
  @SerializedName("Firstcry_brand")  val firstCry: ArrayList<StoreItem>,
  @SerializedName("flipbrand")  val flipkart: ArrayList<StoreItem>,
  @SerializedName("Infibeam_brand")  val infiBeam: ArrayList<StoreItem>,
  @SerializedName("Limeroad_brand")  val limeRoad: ArrayList<StoreItem>,
  @SerializedName("Shopclues_brand")  val shopClues: ArrayList<StoreItem>,
  @SerializedName("Snapdeal_brand")  val snapDeal: ArrayList<StoreItem>
)