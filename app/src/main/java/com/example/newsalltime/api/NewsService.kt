package com.example.newsalltime.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsService {
    private const val BASE_URL="https://newsapi.org/v2/"

    private fun getInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: NewsInterface= getInstance().create(NewsInterface::class.java)

}