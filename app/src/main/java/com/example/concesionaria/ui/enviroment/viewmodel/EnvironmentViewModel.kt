package com.example.concesionaria.ui.enviroment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.concesionaria.model.dto.HousesEnvironmentResponse
import com.example.concesionaria.model.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EnvironmentViewModel(private val serviceImp: Repository = Repository()) : ViewModel() {
    val dataEnvironment = MutableLiveData<HousesEnvironmentResponse>()

    fun getEnvironment(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = serviceImp.getEnvironment(id)
            if (call.isSuccessful) {
                dataEnvironment.postValue(call.body())
            }
        }
    }
}
