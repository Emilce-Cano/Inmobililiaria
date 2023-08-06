package com.example.concesionaria.ui.enviroment.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.concesionaria.databinding.ActivityEnvironmentsBinding
import com.example.concesionaria.model.dto.ImageHouseData
import com.example.concesionaria.ui.home.adapter.EnvironmentAdapter
import com.example.concesionaria.ui.home.viewmodel.HomeViewModel

class EnvironmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnvironmentsBinding

    //cambiar a EnvironmentsViewModel cuando este preparado
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnvironmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun initRecyclerView(listImage : List<ImageHouseData>){
        val adapter = EnvironmentAdapter(listImage)
        binding.rvHouseEnvironments.adapter = adapter
    }

    private fun showLoading() {
        //binding.progressBar.visibility = View.VISIBLE
        //binding.rvEnvironments.visibility = View.GONE
        //binding.tvError.visibility = View.GONE
    }

    private fun calls() {
        //cambiar a getEnvironments cuando este preparado
        viewModel.getHouses()
    }

    private fun observers() {
        viewModel.dataEnviroment.observe(this) {
            initRecyclerView(it.images)
        }
    }

    private fun showSuccess() {
        //Sacar comentario cuando este preparado y probar

        //binding.progressBar.visibility = View.GONE
        //binding.rvHouseEnvironments.visibility = View.VISIBLE
        //binding.tvError.visibility = View.GONE
    }

    private fun showError() {
        //Sacar comentario cuando este preparado y probar

        //binding.progressBar.visibility = View.GONE
        //binding.rvHouseEnvironments.visibility = View.GONE
        //binding.tvError.visibility = View.VISIBLE
        //binding.tvError.text = "Error al cargar datos. Inténtalo nuevamente."
    }
}
