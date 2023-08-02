package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.example.concesionaria.databinding.ActivityLoginBinding
import com.example.concesionaria.UserAplication.Companion.data

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    val viewModel by viewModels<ProductViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        action()
    }

    fun action() {
        validateLogin()
        viewModel.nickNameData.observe(this) {
            binding.loginLlEntry.isEnabled = it
        }
        SetOnClick()
    }

    fun validateLogin() {
        binding.loginEtNickName.doAfterTextChanged {
            viewModel.checkNickName(it.toString())
        }
    }

    fun SetOnClick() {
        binding.loginLlEntry.setOnClickListener {
            data.setName(binding.loginEtNickName.text.toString())
            goToHomeView()
        }

    }

    fun goToHomeView() {
        startActivity(Intent(this, HomeActivity::class.java))
    }
}

