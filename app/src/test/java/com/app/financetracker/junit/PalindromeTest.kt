package com.app.financetracker.junit

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class PalindromeTest {

    lateinit var helper : Helper

    @Before
    fun setUp() {
        helper = Helper()
    }

    @After
    fun tearDown() {
        println("After every test case")
    }

    @Test
    fun isPalindrome() {
        // Arrange
        // Act
        val result = helper.isPalindrome("hello")
        // Assert
        assertEquals(false, result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {
        val result = helper.isPalindrome("level")
        assertEquals(true, result)
    }
}