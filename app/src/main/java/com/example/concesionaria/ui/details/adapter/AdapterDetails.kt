package com.example.concesionaria.ui.details.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.R
import com.example.concesionaria.databinding.ItemDetailsRoomsBinding
import com.example.concesionaria.model.dto.EnvironmentDetailsResponse
import com.squareup.picasso.Picasso

class AdapterDetails(private val imageList: List<EnvironmentDetailsResponse>) :
    RecyclerView.Adapter<DetailsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_details_rooms, parent, false)
        return DetailsHolder(view)
    }

    override fun onBindViewHolder(holder: DetailsHolder, position: Int) {
        holder.render(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}

class DetailsHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemDetailsRoomsBinding.bind(view)

    fun render(value: EnvironmentDetailsResponse) {
        Picasso.get()
            .load("https://www.construyehogar.com/wp-content/uploads/2014/06/Dise%C3%B1o-de-dormitorio-moderno-con-pared-de-letras-Ng%E1%BB%8Dc-B%C3%A1u.jpg")
            .into(binding.ivImage)
    }
}