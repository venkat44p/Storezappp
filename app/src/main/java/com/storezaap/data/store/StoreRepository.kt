package com.storezaap.data.store

import com.storezaap.data.BrandCategory
import com.storezaap.data.Result
import com.storezaap.data.apis.RetrofitClient
import com.storezaap.utils.StatusCodes
import com.storezaap.utils.logE

class StoreRepository {
    suspend fun storeData(category: String): Result<ArrayList<StoreItem>> {
        var msg = ""
        var storeItem: ArrayList<StoreItem>? = null
        val response = RetrofitClient.api.storeData()
        return try {

            if (response.isSuccessful && response.code() == StatusCodes.OK) {
                val body = response.body()
                if (body != null) {
                    if (body.responseCode == StatusCodes.OK) {
                        storeItem = when (category) {
                            BrandCategory.AMAZON -> body.amazon
                            BrandCategory.EBAY -> body.ebay
                            BrandCategory.FIRSTCRY -> body.firstCry
                            BrandCategory.FLIPKART -> body.flipkart
                            BrandCategory.INFIBEAM -> body.infiBeam
                            BrandCategory.LIMEROAD -> body.limeRoad
                            BrandCategory.SHOPCLUES -> body.shopClues
                            BrandCategory.SNAPDEAL -> body.snapDeal
                            else -> body.amazon
                        }

                    } else {
                        msg = "Something went wrong!"
                    }
                }
            }

            Result.Success(storeItem!!)
        } catch (e: Exception) {
            logE(TAG, e)
            Result.Error(msg)
        }
    }

    companion object {
        const val TAG = "StoreRepository"
    }

}