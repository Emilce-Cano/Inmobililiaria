package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.concesionaria.UserAplication.Companion.data
import com.example.concesionaria.databinding.ActivityHomeBinding
import com.example.concesionaria.databinding.ItemHouseHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()
    }

    fun setOnClick() {
        binding.btnLogout.setOnClickListener {
            data.clear()
            goToLogInView()
        }
    }

    fun goToLogInView() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
    fun starFavorites(){

    }
}


