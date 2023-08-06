package com.example.concesionaria.ui.login.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.concesionaria.R
import com.example.concesionaria.databinding.ActivityLoginBinding
import com.example.concesionaria.aplication.UserAplication.Companion.data
import com.example.concesionaria.ui.home.presenter.HomeActivity
import com.example.concesionaria.ui.home.viewmodel.HomeViewModel
import com.example.concesionaria.ui.home.viewmodel.HomeViewModelFactory

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: HomeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getViewModel()
        action()
    }

    fun action() {
        validateLogin()
        viewModel.nickNameData.observe(this) {
            binding.loginBtEntry.isEnabled = it
            if (!it) {
                binding.loginBtEntry.setBackgroundResource(R.drawable.radius_blue_lite_off)
                binding.loginBtEntry.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_login_home_off, 0)
            }
            if (it) {
                binding.loginBtEntry.setBackgroundResource(R.drawable.radius_blue_lite_on)
                binding.loginBtEntry.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_login_home_on, 0)
            }
        }
        setOnClick()
    }

    fun validateLogin() {
        binding.loginEtNickName.doAfterTextChanged {
            viewModel.checkNickName(it.toString())
        }
    }

    fun setOnClick() {
        binding.loginBtEntry.setOnClickListener {
            data.setName(binding.loginEtNickName.text.toString())
            goToHomeView()
        }

    }

    fun goToHomeView() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun getViewModel() {
        viewModel = HomeViewModelFactory().create(HomeViewModel::class.java)
    }
}

