package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        data.clear()
        init()
        checkUserValues()
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

    fun checkUserValues() {
        if (data.getName()!!.isNotEmpty()) {
            goHome()
        }
    }

    fun init() {
        binding.loginLlEntry.setOnClickListener {
            //mover estas dos lineas a true de la validacion
            data.setName(binding.loginEtNickName.text.toString())
            goHome()
        }

    }

    fun goHome(){
        binding.loginLlEntry.setOnClickListener {
            data.setName(binding.loginEtNickName.text.toString())
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }





}
