package com.example.concesionaria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.concesionaria.data.HousesEnvironmentResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class ProductViewModel(val serviceImp: ServiceImp = ServiceImp()) : ViewModel() {
    val nickNameData = MutableLiveData<Boolean>(false)

    fun checkNickName(nickName: String) {
        nickNameData.postValue(Utils.checkNickName(nickName))
    }
    val data = MutableLiveData<HousesEnvironmentResponse>()

    fun getOneHouse() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = serviceImp.getOneHouse()
            if (call.images != null) {
                data.postValue(call)
            }
        }
    }
}
