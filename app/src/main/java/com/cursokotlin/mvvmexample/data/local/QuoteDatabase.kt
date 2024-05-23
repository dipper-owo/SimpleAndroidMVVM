package com.cursokotlin.mvvmexample.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cursokotlin.mvvmexample.data.local.dao.QuoteDao
import com.cursokotlin.mvvmexample.data.local.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}