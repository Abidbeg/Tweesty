package com.example.tweesty

import org.junit.Assert.*

import org.junit.Test

class ForTestCasesTest {

    @Test
    fun passwordCheck() {
        var forTestCases = ForTestCases()
        val result = forTestCases.passwordCheck("     ")
        assertEquals("Password Should not allow blank", result)
    }

    @Test
    fun passwordCheckGreaterLenght() {
        var forTestCases = ForTestCases()
        val result = forTestCases.passwordCheck("Pass")
        assertEquals("Password Must be greater than 6", result)
    }

    @Test
    fun passwordCheckLessLenght() {
        var forTestCases = ForTestCases()
        val result = forTestCases.passwordCheck("PasswordDataNotValidfor")
        assertEquals("Password must be less than 15", result)
    }

    @Test
    fun passwordCheckValid() {
        var forTestCases = ForTestCases()
        val result = forTestCases.passwordCheck("qwert@123")
        assertEquals("Valid", result)
    }

    @Test
    fun reverseCheckValid() {
        var forTestCases = ForTestCases()
        val result = forTestCases.reversString("Abidbeg")
        assertEquals("gebdibA", result)
    }



}