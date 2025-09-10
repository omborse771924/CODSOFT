package com.codsoft.quote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class QuoteActivity : AppCompatActivity() {
    private lateinit var api: QuoteApi
    private var quotes: List<Quote> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_quote)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://type.fit/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(QuoteApi::class.java)

        lifecycleScope.launch {
            try {
                quotes = api.getQuotes()
                // showTodayQuote()
            } catch (e: Exception) {
                // fallback
            }
        }
    }
}
