package com.example.concesionaria

import android.content.SharedPreferences
import android.content.Context

class LocalData(context: Context) {

    val userKey = "user"

    val shared: SharedPreferences = context.getSharedPreferences("nombre", Context.MODE_PRIVATE)

    fun setName(name: String) {
        shared.edit().putString(userKey, name).apply()
    }

    fun getName(): String? {
        return shared.getString(userKey, "")
    }

    fun clear() {
        shared.edit().clear().apply()
    }
}
