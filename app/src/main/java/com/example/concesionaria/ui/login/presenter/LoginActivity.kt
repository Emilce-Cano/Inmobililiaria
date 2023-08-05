package com.example.concesionaria.ui.login.presenter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
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
            binding.loginLlEntry.isEnabled = it
        }
        setOnClick()
    }

    fun validateLogin() {
        binding.loginEtNickName.doAfterTextChanged {
            viewModel.checkNickName(it.toString())
        }
    }

    fun setOnClick() {
        binding.loginLlEntry.setOnClickListener {
            data.setName(binding.loginEtNickName.text.toString())
            goToHomeView()
        }

    }

    fun goToHomeView() {
        startActivity(Intent(this, HomeActivity::class.java))
    }

    private fun getViewModel() {
<<<<<<< HEAD:app/src/main/java/com/example/concesionaria/LoginActivity.kt
        viewModel = ViewModelFactory().create(HomeViewModel::class.java)
=======
        viewModel =
            HomeViewModelFactory().create(HomeViewModel::class.java)
>>>>>>> 7598b28c757e8a280e09bba68bff223ea41b6246:app/src/main/java/com/example/concesionaria/ui/login/presenter/LoginActivity.kt
    }
}

