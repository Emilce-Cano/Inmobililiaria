package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
        checkUserValues()
    }
    fun checkUserValues(){
        if(UserAplication.data.getName()!!.isNotEmpty()){
            goToHomeView()
        }else{
            goToLogInView()
        }
    }
    fun goToLogInView(){
        startActivity(Intent(this, LoginActivity::class.java))
    }
    fun goToHomeView(){
        startActivity(Intent(this, HomeActivity::class.java))
    }
}
