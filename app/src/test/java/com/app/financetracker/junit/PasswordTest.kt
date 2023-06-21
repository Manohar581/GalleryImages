package com.app.financetracker.junit

import org.junit.Assert.*
import org.junit.Test

class PasswordTest {

    @Test
    fun validatePassword_blankInput_expectedRequiredField() {
        val sut = Helper()
        val result = sut.validatePassword("")
        assertEquals("Password is required field", result)
    }

    @Test
    fun validatePassword_2Char_Input_expectedValidationMsg() {
        val sut = Helper()
        val result = sut.validatePassword("ab")
        assertEquals("Length of the password should be greater than 6", result)
    }

    @Test
    fun validatePassword_CorrectInput_expectedValidPassword() {
        val sut = Helper()
        val result = sut.validatePassword("ThisIsAPass")
        assertEquals("Valid", result)
    }
}