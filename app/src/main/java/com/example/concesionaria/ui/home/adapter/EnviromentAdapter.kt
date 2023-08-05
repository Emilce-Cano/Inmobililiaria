package com.example.concesionaria.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.R
import com.example.concesionaria.databinding.ItemRvHomeEnvironmentsBinding
import com.example.concesionaria.model.dto.ImageHouseData
import com.squareup.picasso.Picasso

class EnvironmentAdapter(private val listOfEnviroment: List<ImageHouseData>) :
    RecyclerView.Adapter<EnvironmentHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnvironmentHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_home_environments, parent, false)
        return EnvironmentHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfEnviroment.size
    }

    override fun onBindViewHolder(holder: EnvironmentHolder, position: Int) {
        holder.render(listOfEnviroment[position])
    }
}

class EnvironmentHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemRvHomeEnvironmentsBinding.bind(view)
    fun render(value: ImageHouseData) {
        Picasso.get().load(value.image).into(binding.ivItemRvHouseHome)
    }
}