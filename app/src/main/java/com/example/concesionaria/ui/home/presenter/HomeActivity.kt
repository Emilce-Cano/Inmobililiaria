package com.example.concesionaria.ui.home.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.concesionaria.model.dto.HousesResponse
import com.example.concesionaria.ui.login.presenter.LoginActivity
import com.example.concesionaria.R
import com.example.concesionaria.aplication.UserAplication.Companion.data
import com.example.concesionaria.ui.home.adapter.AdapterHome
import com.example.concesionaria.databinding.ActivityHomeBinding
import com.example.concesionaria.ui.enviroment.presenter.EnvironmentsActivity
import com.example.concesionaria.ui.home.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observers()
        calls()
        setOnClick()
    }

    private fun setOnClick() {
        binding.btnLogout.setOnClickListener {
            data.clear()
            goToLogInView()
        }
    }

    private fun goToLogInView() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun showLoading() {
        //binding.progressBar.visibility = View.VISIBLE
        //binding.rvHouseHome.visibility = View.GONE
        //binding.tvError.visibility = View.GONE
    }

    private fun calls() {
        viewModel.getHouses()
    }

    private fun observers() {
        viewModel.data.observe(this) {
            initRecyclerView(it.houses)
        }
    }

    private fun showSuccess() {
        //binding.progressBar.visibility = View.GONE
        //binding.rvHouseHome.visibility = View.VISIBLE
        //binding.tvError.visibility = View.GONE
    }

    private fun showError() {
        //binding.progressBar.visibility = View.GONE
        //binding.rvHouseHome.visibility = View.GONE
        //binding.tvError.visibility = View.VISIBLE
        //binding.tvError.text = "Error al cargar datos. In
        // téntalo nuevamente."
    }

    private fun initRecyclerView(listImage: List<HousesResponse.Data>) {
        val adapter = AdapterHome(listImage, onClick = { goToDetails.invoke(it) })
        binding.rvHouseHome.adapter = adapter
    }

    private val goToDetails = fun(value: HousesResponse.Data) {
        val intent = Intent(this, EnvironmentsActivity::class.java)
        intent.putExtra("id",value.id)
        startActivity(intent)
    }
}
