package com.example.concesionaria.ui.enviroment.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.concesionaria.databinding.ActivityEnvironmentsBinding
import com.example.concesionaria.model.dto.ImageHouseData
import com.example.concesionaria.ui.details.presenter.DetailsActivity
import com.example.concesionaria.ui.enviroment.adapter.EnvironmentAdapter
import com.example.concesionaria.ui.enviroment.viewmodel.EnvironmentViewModel

class EnvironmentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnvironmentsBinding

    private val viewModel by viewModels<EnvironmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEnvironmentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        calls(getBundle())
        observers()

    }

    private fun initRecyclerView(listImage: List<ImageHouseData>) {
        val adapter = EnvironmentAdapter(listImage, onClick = { goToDetails.invoke(it) })
        binding.rvHouseEnvironments.adapter = adapter

    }


    private fun showLoading() {
        //binding.progressBar.visibility = View.VISIBLE
        //binding.rvEnvironments.visibility = View.GONE
        //binding.tvError.visibility = View.GONE
    }

    private fun calls(id:String) {
        viewModel.getEnvironment(id)
    }

    private fun observers() {
        viewModel.dataEnvironment.observe(this) {
            initRecyclerView(it.images)
            binding.tvTitleDescription.text = it.description
            binding.tvTitleState.text = it.state
        }
    }

    fun getBundle():String{
        val bundle = intent.extras
        val id = bundle?.getString("id")
        return id.toString()
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

    private val goToDetails = fun(value: ImageHouseData) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("id", value.id)
        startActivity(intent)
    }
}
