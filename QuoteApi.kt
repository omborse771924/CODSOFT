package com.codsoft.quote

import retrofit2.http.GET

interface QuoteApi {
    @GET("api/quotes")
    suspend fun getQuotes(): List<Quote>
}
