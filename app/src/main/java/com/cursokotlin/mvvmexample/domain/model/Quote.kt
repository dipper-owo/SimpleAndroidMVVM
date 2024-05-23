package com.cursokotlin.mvvmexample.domain.model

import com.cursokotlin.mvvmexample.data.local.entities.QuoteEntity
import com.cursokotlin.mvvmexample.data.remote.model.QuoteModel

data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)