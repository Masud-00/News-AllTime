package com.example.newsalltime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.newsalltime.api.NewsInterface
import com.example.newsalltime.model.News
import retrofit2.Response

class Repository(private val newsService: NewsInterface) {
    private val allNews=MutableLiveData<Response<News>>()
    val articles: LiveData<Response<News>>
    get()=allNews

    suspend fun getNews(category: String, country: String, apikey: String){
        val result=newsService.getNews(category,country,apikey)
        if(result.body()!=null){
            allNews.postValue(Response.success(result.body()!!))
        }
    }

}