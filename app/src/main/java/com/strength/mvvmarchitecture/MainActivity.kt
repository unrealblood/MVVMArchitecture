package com.strength.mvvmarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.strength.mvvmarchitecture.data.QuoteDatabaseInstance
import com.strength.mvvmarchitecture.databinding.ActivityMainBinding
import com.strength.mvvmarchitecture.viewmodels.MainViewModel
import com.strength.mvvmarchitecture.viewmodels.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)

        val quoteDao = QuoteDatabaseInstance.getDatabaseInstance(applicationContext).quoteDao()

        val quoteRepository = QuoteRepository(quoteDao)

        mainViewModel = ViewModelProvider(this@MainActivity, MainViewModelFactory(quoteRepository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this@MainActivity, Observer {
            binding.quotes = it.toString()
        })
    }
}