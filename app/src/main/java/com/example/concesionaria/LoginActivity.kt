package com.example.concesionaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.example.concesionaria.databinding.ActivityLoginBinding

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
    }

    fun validateLogin() {
        binding.loginEtNickName.doAfterTextChanged {
            viewModel.checkNickName(it.toString())
        }
    }
}
