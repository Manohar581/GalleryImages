package com.app.financetracker.junit

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    @Test(expected = FileNotFoundException::class)
    fun populateQuotesFromAssets() {
        val quoteManger = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManger.populateQuotesFromAssets(context, "")
    }

    @Test(expected = JsonSyntaxException::class)
    fun testPopulateQuotesFromAssets_InvalidJSON_expected_Exception() {
        val quoteManger = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManger.populateQuotesFromAssets(context, "malformed.json")
    }

    @Test
    fun testPopulateQuotesFromAssets_ValidJSON_expected_Count() {
        val quoteManger = QuoteManager()
        val context = ApplicationProvider.getApplicationContext<Context>()
        quoteManger.populateQuotesFromAssets(context, "quotes.json")
        assertEquals(5, quoteManger.quoteList.size)
    }

    @Test
    fun testPreviousQuote_ValidJSON_expected_CorrectQuote() {
        val quoteManger = QuoteManager()
        quoteManger.populateQuotes(
            arrayOf(
                Quote("This is first quore", "1"),
                Quote("This is Second quore", "2"),
                Quote("This is Third quore", "3")
            )
        )
        val quote = quoteManger.getPreviousQuote()
        assertEquals("1", quote.author)
    }

    @Test
    fun testNextQuote_ValidJSON_expected_CorrectQuote() {
        val quoteManger = QuoteManager()
        quoteManger.populateQuotes(
            arrayOf(
                Quote("This is first quote", "1"),
                Quote("This is Second quote", "2"),
                Quote("This is Third quote", "3")
            )
        )
        val quote = quoteManger.getNextQuote()
        assertEquals("2", quote.author)
    }
}