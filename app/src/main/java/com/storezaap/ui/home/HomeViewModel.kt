package com.storezaap.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denzcoskun.imageslider.models.SlideModel
import com.storezaap.data.BrandData
import com.storezaap.data.BrandImageData
import com.storezaap.data.apis.RetrofitClient
import com.storezaap.utils.logE
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {


    private var _slideList: MutableLiveData<ArrayList<SlideModel>> = MutableLiveData()
    val slideList: LiveData<ArrayList<SlideModel>> = _slideList

    private var _brandImages: MutableLiveData<ArrayList<BrandImageData>> = MutableLiveData()
    val brandImages: LiveData<ArrayList<BrandImageData>> = _brandImages

    private var _brandData: MutableLiveData<ArrayList<BrandData>> = MutableLiveData()
    val brandData: LiveData<ArrayList<BrandData>> = _brandData




    fun getHomeData() {
        viewModelScope.launch {

            RetrofitClient.api.home("test")

                .enqueue(object : Callback<ResponseBody> {
                    override fun onResponse(
                        call: Call<ResponseBody>, response: Response<ResponseBody>
                    ) {

                        try {


                            val body = response.body()!!.string()

                            val jsonObject = JSONObject(body)

                            if (response.isSuccessful) {

                                val sliders: ArrayList<SlideModel> = ArrayList()
                                // SliderImage
                                val slider = JSONArray(jsonObject.getString("slider"))
                                for (i in 0 until slider.length()) {
                                    sliders.add(SlideModel(slider.getString(i)))
                                }

                                _slideList.value = sliders


                                val brandCards: ArrayList<BrandImageData> =
                                    ArrayList()

                                // Top deals
                                val brandCard = JSONArray(jsonObject.getString("brand_Card"))

                                for (x in 0 until brandCard.length()) {
                                    brandCards.add(BrandImageData(brandCard.getString(x)))
                                }

                                _brandImages.value=brandCards


                                val brandData: ArrayList<BrandData> = ArrayList()

                                // Today's Deals
                                val brand = JSONArray(jsonObject.getString("brand"))
                                for (x in 0 until brand.length()) {
                                    val item = brand.getJSONObject(x)
                                    brandData.add(
                                        BrandData(
                                            item.getString("Image"),
                                            item.getString("Brand_Name"),
                                            item.getString("url")
                                        )
                                    )
                                }

                                _brandData.value=brandData


                            }

                        } catch (e: Exception) {
                            logE(TAG, e)
                        }


                    }

                    override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                        logE(TAG, t)
                    }
                })
        }
    }

    companion object {
        private const val TAG = "HomeViewModel"
    }


}