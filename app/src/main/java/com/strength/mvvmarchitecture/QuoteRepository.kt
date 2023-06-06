package com.strength.mvvmarchitecture

import androidx.lifecycle.LiveData
import com.strength.mvvmarchitecture.data.QuoteDAO
import com.strength.mvvmarchitecture.data.QuoteData

class QuoteRepository(private val quoteDAO: QuoteDAO) {
    fun getQuotes() : LiveData<List<QuoteData>> {
        return quoteDAO.getQuotes()
    }

    suspend fun insertQuote(quoteData: QuoteData) {
        quoteDAO.insertQuote(quoteData)
    }
}