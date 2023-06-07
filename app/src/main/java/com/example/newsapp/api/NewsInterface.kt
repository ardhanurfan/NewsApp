package com.example.newsapp.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import com.example.newsapp.data.News

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "5a57e48f3510460788ae79cd5e2de257"

interface NewsInterface {

    @GET("v2/top-headlines?country=us&apiKey=$API_KEY")
    fun getHeadLines() : Call<News>

 @GET("v2/everything?q=apple&apiKey=$API_KEY")
    fun getAllNews() : Call<News>

}

object NewsService{

    val newsInstance: NewsInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}