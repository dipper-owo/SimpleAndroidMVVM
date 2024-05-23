package com.cursokotlin.mvvmexample.data

import com.cursokotlin.mvvmexample.data.local.dao.QuoteDao
import com.cursokotlin.mvvmexample.data.local.entities.QuoteEntity
import com.cursokotlin.mvvmexample.data.remote.model.QuoteModel
import com.cursokotlin.mvvmexample.data.remote.QuoteService
import com.cursokotlin.mvvmexample.domain.model.Quote
import com.cursokotlin.mvvmexample.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService, private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        quoteDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}