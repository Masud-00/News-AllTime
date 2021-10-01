package com.example.newsalltime.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsalltime.Repository
import com.example.newsalltime.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(val repository: Repository): ViewModel() {

    fun getNews(category:String,country:String,apikey:String){

        viewModelScope.launch(Dispatchers.IO) {
            repository.getNews(category, country, apikey)
        }
    }
    val articles: LiveData<Response<News>>
    get()=repository.articles
}