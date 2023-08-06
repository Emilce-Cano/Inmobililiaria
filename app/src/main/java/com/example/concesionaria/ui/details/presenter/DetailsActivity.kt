package com.example.concesionaria.ui.details.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concesionaria.databinding.ActivityDetailsBinding
import com.example.concesionaria.model.dto.EnvironmentDetailsResponse
import com.example.concesionaria.ui.details.adapter.AdapterDetails
import com.example.concesionaria.ui.details.viewmodel.DetailsViewModel

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    val viewModel by viewModels<DetailsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        call()
        observers()

    }

    private fun call() {
        viewModel.getDetails(getBundle())
    }

    private fun observers() {
        viewModel.data.observe(this) {
            detailsRecyclerView(it.images)
            binding.tvMeasureRoomDetails.text = it.measures
            binding.tvColourRoomDetails.text = it.color
        }

    }

    private fun getBundle(): String {
        val bundle = intent.extras
        val id = bundle?.getString("id")
        return id.toString()
    }

    private fun detailsRecyclerView(list: List<String>) {
        val adapter = AdapterDetails(list)
        binding.detailsRvGridRooms.layoutManager = GridLayoutManager(this, 2)
        binding.detailsRvGridRooms.adapter = adapter
    }
}
