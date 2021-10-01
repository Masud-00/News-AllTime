package com.example.newsalltime.api

import com.example.newsalltime.model.News
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {
    @GET("top-headlines")
 suspend fun getNews(@Query("category") category: String, @Query("country") country: String, @Query("apiKey") apiKey: String): retrofit2.Response<News>


}