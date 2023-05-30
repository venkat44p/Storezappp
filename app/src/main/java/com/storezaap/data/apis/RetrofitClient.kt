package com.storezaap.data.apis

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val BASE_URL = "https://storezaap.com/mpp/android_test_API/"
    //  private val BASE_URL = "http://192.168.1.236/store/"

  private  val instance:Retrofit by lazy {
         val builder = OkHttpClient.Builder()
         val interceptor = HttpLoggingInterceptor()

        val gson = GsonBuilder()
            .setLenient()
            .create()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        builder.addInterceptor(interceptor)


        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    val api: ApiService by lazy {
        instance.create(ApiService::class.java)
    }


}