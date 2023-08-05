package com.example.concesionaria.ui.home.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.concesionaria.ui.login.presenter.LoginActivity
import com.example.concesionaria.R
import com.example.concesionaria.aplication.UserAplication.Companion.data
import com.example.concesionaria.ui.home.adapter.AdapterHome
import com.example.concesionaria.model.dto.ImageHouseData
import com.example.concesionaria.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()

    }

   private fun setOnClick() {
        binding.btnLogout.setOnClickListener {
            data.clear()
            goToLogInView()
        }
    }

   private fun goToLogInView() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun initRecyclerView(listImage: List<ImageHouseData>){
        val adapter = AdapterHome(listImage)
        binding.rvHouseHome.adapter = adapter
    }
}
