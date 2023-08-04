package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.concesionaria.UserAplication.Companion.data
import com.example.concesionaria.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setOnClick()
    }

    fun setOnClick() {
        binding.btnLogout.setOnClickListener {
            data.clear()
            goToLogInView()
        }
    }

    fun goToLogInView() {
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun showLoading() {
        //binding.progressBar.visibility = View.VISIBLE
        //binding.rvHouseHome.visibility = View.GONE
        //binding.tvError.visibility = View.GONE
    }

    private fun calls() {
        viewModel.getOneHouse()
    }

    private fun observers() {
        viewModel.data.observe(this) {
            //initRecyclerView(it)
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
        //binding.tvError.text = "Error al cargar datos. Inténtalo nuevamente."
    }
}
