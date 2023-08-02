package com.example.concesionaria

object Utils {
    fun checkNickName(nickName: String): Boolean {
        var alphabetNickName = true
        nickName.forEach {
            if (alphabetNickName) {
                when (it.toString().lowercase()) {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" -> alphabetNickName =
                        true
                    else -> {
                        alphabetNickName = false
                    }
                }
            }
        }
        return (nickName.isNotEmpty() && nickName.length < 20 && !nickName.contains(" ") && !nickName.contains(
            ","
        ) && alphabetNickName)
    }
}
