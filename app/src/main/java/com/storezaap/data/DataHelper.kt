package com.storezaap.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.storezaap.data.user.UserData
import java.io.File
import java.util.*

object DataHelper {

    private var applicationContext: Context? = null
    private val context get() = applicationContext!!


    fun initialize(applicationContext: Context) {
        this.applicationContext = applicationContext.applicationContext
    }

    private val sharedPreference: SharedPreferences by lazy {
        if (applicationContext == null) {
            throw UninitializedPropertyAccessException("Application Context must be initialized before accesing")
        }
        context.getSharedPreferences(KEY.SHARED_PREF_FILE, Context.MODE_PRIVATE)
    }


    var id: Int
        get() {
            return sharedPreference.getInt(KEY.ID, -1)
        }
        set(value) {
            sharedPreference.edit {
                putInt(KEY.ID, value)
                apply()
            }
        }


    var userName: String?
        get() {
            return sharedPreference.getString(KEY.USER_NAME, null)
        }
        set(value) {
            sharedPreference.edit {
                putString(KEY.USER_NAME, value)
                apply()
            }
        }


    var email: String?
        get() {
            return sharedPreference.getString(KEY.EMAIL, null)
        }
        set(value) {
            sharedPreference.edit {
                putString(KEY.EMAIL, value)
                apply()
            }
        }

    var isLoggedIn: Boolean
        get() {
            return sharedPreference.getBoolean(KEY.IS_LOGGED_IN, false)
        }
        set(value) {
            sharedPreference.edit {
                putBoolean(KEY.IS_LOGGED_IN, value)
                apply()
            }
        }

    var lastTimeAppUsed: Date
        get() {
            val mills = sharedPreference.getLong(KEY.LAST_TIME_APP_USED, System.currentTimeMillis())
            return Date(mills)
        }
        set(value) {
            sharedPreference.edit {
                putLong(KEY.LAST_TIME_APP_USED, value.time)
                apply()
            }
        }

    var isLastTimeAppUseSaved: Boolean
        get() {
            return sharedPreference.getBoolean(KEY.IS_LAST_TIME, false)
        }
        set(value) {
            sharedPreference.edit {
                putBoolean(KEY.IS_LAST_TIME, value)
                apply()
            }
        }


    var profileImageUrl: String?
        get() {
            return sharedPreference.getString(KEY.PROFILE_IMAGE_URL, null)
        }
        set(value) {
            sharedPreference.edit {
                putString(KEY.PROFILE_IMAGE_URL, value)
                apply()
            }
        }


    fun logOut() {

        sharedPreference.edit {
            clear()
            apply()
        }

        val file = File(context.filesDir, "profile_image.jpg")
        if (file.exists()) {
            file.delete()
        }


    }

    var user: UserData
        set(value) {
            id = value.id
            email = value.email
            userName = value.name
            profileImageUrl = value.picUrl
        }
        get() {
            return UserData(
                id = id, email = email, name = userName, picUrl = profileImageUrl
            )
        }


    object KEY {
        const val SHARED_PREF_FILE = "shared_pref_file"
        const val ID = "id"
        const val USER_NAME = "user_name"
        const val EMAIL = "email"
        const val IS_LOGGED_IN = "is_logged_in"
        const val LAST_TIME_APP_USED = "last_time_app_used"
        const val IS_LAST_TIME = "is_last_time"
        const val PROFILE_IMAGE_URL = "profile_image_url"
    }


}