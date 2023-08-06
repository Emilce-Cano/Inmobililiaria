package com.example.concesionaria.utils

object Utils {
    fun checkNickName(nickName: String): Boolean {
        return nickName.length in 5..19 && nickName.all { it.isLetter() } && !nickName.contains(" ")
    }
}
