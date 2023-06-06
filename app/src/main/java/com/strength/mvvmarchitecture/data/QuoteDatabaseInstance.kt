package com.strength.mvvmarchitecture.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [QuoteData::class], version = 1)
abstract class QuoteDatabaseInstance : RoomDatabase() {
    abstract fun quoteDao() : QuoteDAO

    companion object {
        private var INSTANCE : QuoteDatabaseInstance? = null

        fun getDatabaseInstance(context: Context) : QuoteDatabaseInstance {
            if(INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, QuoteDatabaseInstance::class.java, "quotes_database")
                        .createFromAsset("quotes.db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}