package com.strength.mvvmarchitecture.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("quote")
data class QuoteData(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val text : String,
    val author : String
)