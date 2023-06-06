package com.strength.mvvmarchitecture.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.strength.mvvmarchitecture.QuoteRepository
import com.strength.mvvmarchitecture.data.QuoteData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() : LiveData<List<QuoteData>> {
        return quoteRepository.getQuotes()
    }

    fun insertQuote(quote : QuoteData) {
        viewModelScope.launch(Dispatchers.IO) {
            quoteRepository.insertQuote(quote)
        }
    }
}