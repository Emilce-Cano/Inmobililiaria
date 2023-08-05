package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.concesionaria.UserAplication.Companion.data
import com.example.concesionaria.adapter.AdapterHome
import com.example.concesionaria.data.HousesResponse
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

    private fun initRecyclerView(listImage: List<HousesResponse.Data>) {
        val adapter = AdapterHome(listImage)
        binding.rvHouseHome.adapter = adapter
    }
}
