package com.example.concesionaria.aplication

import android.app.Application
import com.example.concesionaria.utils.LocalData

class UserAplication : Application() {
    companion object {
        lateinit var data: LocalData
    }

    override fun onCreate() {
        super.onCreate()
        data = LocalData(applicationContext)
    }
}
