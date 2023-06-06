package com.strength.mvvmarchitecture.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDAO {
    @Insert
    suspend fun insertQuote(quoteData: QuoteData)

    @Delete
    suspend fun deleteQuote(quoteData: QuoteData)

    @Update
    suspend fun updateQuote(quoteData: QuoteData)

    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<QuoteData>>
}