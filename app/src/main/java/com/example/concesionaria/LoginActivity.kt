package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.concesionaria.UserAplication.Companion.data
import com.example.concesionaria.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        checkUserValues()
    }

    fun checkUserValues(){
        if(data.getName()!!.isNotEmpty()){
            goHome()
        }
    }
    fun init(){
        binding.loginLlEntry.setOnClickListener {
            //mover estas dos lineas a true de la validacion
            data.setName(binding.loginEtNickName.text.toString())
            goHome()
        }

    }

    fun goHome(){
        startActivity(Intent(this, HomeActivity::class.java))
    }
}
