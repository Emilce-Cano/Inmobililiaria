package com.example.concesionaria.ui.details.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concesionaria.databinding.ActivityDetailsBinding
import com.example.concesionaria.model.dto.EnvironmentDetailsResponse
import com.example.concesionaria.ui.details.adapter.AdapterDetails

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun detailsRecyclerView(list: List<EnvironmentDetailsResponse>) {
        val adapter = AdapterDetails(list)
        binding.detailsRvGridRooms.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.detailsRvGridRooms.adapter = adapter
        binding.detailsRvGridRooms.layoutManager = GridLayoutManager(this, 2)
    }

}

