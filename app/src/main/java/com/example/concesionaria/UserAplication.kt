package com.example.concesionaria

import android.app.Application

class UserAplication : Application() {
    companion object{
        lateinit var data: LocalData
    }
    override fun onCreate() {
        super.onCreate()
        data = LocalData(applicationContext)
    }
}