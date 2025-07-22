package com.example.kingshoppers.utils

import android.content.Context
import android.content.SharedPreferences

object PrefManager {

    private const val PREF_NAME = "user_session"
    private const val KEY_IS_LOGGED_IN = "is_logged_in"
    private const val KEY_USER_ID = "user_id" // example extra key

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    fun setLoginStatus(context: Context, status: Boolean) {
        getPreferences(context).edit().putBoolean(KEY_IS_LOGGED_IN, status).apply()
    }

    fun getLoginStatus(context: Context): Boolean {
        return getPreferences(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun setUserId(context: Context, userId: String) {
        getPreferences(context).edit().putString(KEY_USER_ID, userId).apply()
    }

    fun getUserId(context: Context): String? {
        return getPreferences(context).getString(KEY_USER_ID, null)
    }

    fun clear(context: Context) {
        getPreferences(context).edit().clear().apply()
    }
}




