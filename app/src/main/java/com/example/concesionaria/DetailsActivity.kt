package com.example.concesionaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.concesionaria.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        action()
    }

    fun action() {
        detailsRecyclerView()
    }

    fun detailsRecyclerView() {
        binding.detailsRvGridRooms.layoutManager = GridLayoutManager(this, 2)

    }
}

