package com.example.concesionaria

import Adapterkkk
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        action()
    }
    fun action(){
        detailsRecyclerView()
    }
    fun detailsRecyclerView(){
        binding.detailsRvGridRooms.layoutManager = GridLayoutManager(this,2)
        binding.detailsRvGridRooms.adapter = Adapterkkk()
    }
}