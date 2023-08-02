package com.example.concesionaria

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ProductViewModel() : ViewModel() {
    val nickNameData = MutableLiveData<Boolean>(false)

    fun checkNickName(nickName: String) {
        nickNameData.postValue(Utils.checkNickName(nickName))
    }
}
