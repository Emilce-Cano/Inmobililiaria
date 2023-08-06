package com.example.concesionaria.utils

import com.example.concesionaria.model.dto.HousesResponse

object Utils {
    fun checkNickName(nickName: String): Boolean {
        return nickName.length in 1..19 && nickName.all { it.isLetter() } && !nickName.contains(" ")
    }

    var ITEM: HousesResponse.Data? = null
}
