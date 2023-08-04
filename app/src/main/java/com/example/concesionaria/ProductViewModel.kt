package com.example.concesionaria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.concesionaria.data.HousesEnvironmentResponse
import com.example.concesionaria.data.HousesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductViewModel(val serviceImp: ServiceImp = ServiceImp()) : ViewModel() {
    val nickNameData = MutableLiveData<Boolean>(false)

    fun checkNickName(nickName: String) {
        nickNameData.postValue(Utils.checkNickName(nickName))
    }

    fun getHouses() {
        CoroutineScope(Dispatchers.IO).launch {
            val data = MutableLiveData<HousesResponse>()
            val call = serviceImp.getHouses()
            if (call.houses != null) {
                data.postValue(call)
            }
        }
    }

    fun getEnviroment(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val data = MutableLiveData<HousesEnvironmentResponse>()
            val call = serviceImp.getEnvironment(id)
            if (call.state != null) {
                data.postValue(call)
            }
        }
    }
}
