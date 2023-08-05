package com.example.concesionaria.aplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.concesionaria.ui.home.presenter.HomeActivity
import com.example.concesionaria.ui.login.presenter.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
        checkUserValues()
    }

    fun checkUserValues() {
        if (!UserAplication.data.getName()!!.isNullOrEmpty()) {
            goToHomeView()
        } else {
            goToLogInView()
        }
    }

    fun goToLogInView() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    fun goToHomeView() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}

