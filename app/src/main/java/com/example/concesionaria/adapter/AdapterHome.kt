package com.example.concesionaria.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.R
import com.example.concesionaria.data.ImageHouseData
import com.example.concesionaria.databinding.ItemHouseHomeBinding
import com.squareup.picasso.Picasso

class AdapterHome(private val houseList: List<ImageHouseData>) : RecyclerView.Adapter<HomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_house_home, parent, false)
        return HomeHolder(view)
    }

    override fun onBindViewHolder(holder: HomeHolder, position: Int) {
        holder.render(houseList[position])
    }

    override fun getItemCount(): Int {
        return houseList.size
    }
}

class HomeHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemHouseHomeBinding.bind(view)


    fun render(value:ImageHouseData) {

        Picasso.get().load(value.image).into(binding.ivItemRvHouseHome)
    }
}