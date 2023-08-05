package com.example.concesionaria.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.R
import com.example.concesionaria.model.dto.HousesResponse
import com.example.concesionaria.databinding.ItemHouseHomeBinding
import com.squareup.picasso.Picasso

<<<<<<< HEAD:app/src/main/java/com/example/concesionaria/adapter/AdapterHome.kt
class AdapterHome(private val houseList: List<ImageHouseData>) :
=======
class AdapterHome(private val houseList: List<HousesResponse.Data>) :
>>>>>>> 7598b28c757e8a280e09bba68bff223ea41b6246:app/src/main/java/com/example/concesionaria/ui/home/adapter/AdapterHome.kt
    RecyclerView.Adapter<HomeHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_house_home, parent, false)
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
<<<<<<< HEAD:app/src/main/java/com/example/concesionaria/adapter/AdapterHome.kt


    fun render(value: ImageHouseData) {
=======
    fun render(value: HousesResponse.Data) {
>>>>>>> 7598b28c757e8a280e09bba68bff223ea41b6246:app/src/main/java/com/example/concesionaria/ui/home/adapter/AdapterHome.kt
        Picasso.get().load(value.image).into(binding.ivItemRvHouseHome)
        binding.saveOffHome.setOnClickListener {
            binding.saveOnHome.visibility = View.VISIBLE
            binding.saveOffHome.visibility = View.GONE
        }
        binding.saveOnHome.setOnClickListener {
            binding.saveOffHome.visibility = View.VISIBLE
            binding.saveOnHome.visibility = View.GONE
        }
    }
}
