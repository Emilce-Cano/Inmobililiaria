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

    val data = MutableLiveData<HousesResponse>()

    fun getHouses() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = serviceImp.getHouses()
            if (call.houses != null) {
                data.postValue(call)
            }
        }
    }

    val stateFavorite = MutableLiveData<Boolean>(false)

    fun stateStartFavorite(){

        stateFavorite.postValue()
    }
}

