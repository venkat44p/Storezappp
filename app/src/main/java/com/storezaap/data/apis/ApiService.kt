package com.storezaap.data.apis

import com.storezaap.data.login.LoginRequest
import com.storezaap.data.login.LoginResponse
import com.storezaap.data.register.RegisterRequest
import com.storezaap.data.register.RegisterResponse
import com.storezaap.data.store.StoreDataResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ApiService {


    @FormUrlEncoded
    @POST("home_new_latest1.php")
    fun home(
        @Field("username") username: String,
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("updatepassword.php")
    fun updatePassword(
        @Field("email") email: String, @Field("current") current: String, @Field("new") new: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("reset-password.php")
    fun forgetPassword(
        @Query("email") email: String,
        @Field("password") temporaryPassword: String,
        @Field("new") newPassword: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @GET("reset-password.php")
    fun resetPassword(@Query("email") email: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("forget_password_new.php")
    fun sendTemporaryPassword(
        @Field("email") email: String
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("updateuser.php")
    fun updateProfile(
        @Field("id") id: String?, @Field("username") username: String, @Field("email") email: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("userdata.php")
    fun getUserDetails(
        @Field("id") id: Int
    ): Call<ResponseBody>


    @Multipart
    @POST("uploadimg.php")
    fun uploadProfileImage(
        @Part upload: MultipartBody.Part, @Part("email") email: RequestBody
    ): Call<ResponseBody>



    @POST(LOGIN_URL)
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST(REGISTER_URL)
    suspend fun register(@Body registerRequest: RegisterRequest): Response<RegisterResponse>


    @GET(STORE_DATA_URL)
    suspend fun storeData(): Response<StoreDataResponse>



    companion object {
        const val BASE_URL = ""
        const val LOGIN_URL = "login"
        const val REGISTER_URL = "register"
        const val STORE_DATA_URL = "amazon_db"
    }


}