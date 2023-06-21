package com.app.financetracker.junit

import org.junit.Assert.assertEquals
import org.junit.Test

class StringTest {

    @Test
    fun testStringReversal_EmptyString_expectedEmptyString() {
        val sut = Helper()
        val result = sut.reverseString("")
        assertEquals("", result)
    }

    @Test
    fun testStringReversal_singleChar_expectedSingleChar() {
        val sut = Helper()
        val result = sut.reverseString("a")
        assertEquals("a", result)
    }

    @Test
    fun testStringReversal_ValidInput_expectedValidString() {
        val sut = Helper()
        val result = sut.reverseString("Hello")
        assertEquals("olleH", result)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testStringReversal_NullValue_expectedException() {
        val sut = Helper()
        val result = sut.reverseString(null)
    }
}