package com.example.concesionaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class LoginActivity : AppCompatActivity() {
    lateinit var binding : ActivityLoginBinding
    lateinit var viewModel: ProductViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = layoutInflater.ActivityLoginBinding(layoutInflater)
        setContentView(binding.root)
        action()
    }
    fun action(){
        val viewModelFactory = ViewModelF()

    }
}
