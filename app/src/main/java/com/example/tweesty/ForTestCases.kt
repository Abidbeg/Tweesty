package com.example.tweesty

import android.util.Log

class ForTestCases {


    fun passwordCheck(pass: String) = when {

        pass.isBlank() -> {
            "Password Should not allow blank"
        }

        pass.length < 6 -> {
            "Password Must be greater than 6"
        }

        pass.length > 15 -> {
            "Password must be less than 15"
        }

        else -> {
            "Valid"
        }
    }

    fun reversString(input: String): String {
        var chars = input.toCharArray()
        var i = 0
        var j = chars.size - 1
        while (i < j) {
            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp
            i++
            j--
        }
        return chars.joinToString("")


    }


}
