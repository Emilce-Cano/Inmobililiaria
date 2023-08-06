package com.example.concesionaria.ui.details.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.concesionaria.model.dto.EnvironmentDetailsResponse
import com.example.concesionaria.model.repository.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel (private val serviceImp: Repository = Repository()):ViewModel() {

    val data = MutableLiveData<EnvironmentDetailsResponse>()

    fun getDetails(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = serviceImp.getDetails(id)
            if (call.isSuccessful) {
                data.postValue(call.body())
            }
        }
    }
}