package com.example.newsapp

import retrofit.http.GET
import retrofit.Call

interface ApiService {

    @GET("jokes/random")
    fun getJokes(): Call<JocksDataModel>

    @GET("v2/everything?q=Apple&from=2023-11-05&sortBy=popularity&apiKey=626962d8aece4a41bd751398cdc00609")
    fun getNewsList(): Call<newsResult>

}