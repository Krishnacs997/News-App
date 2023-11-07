package com.example.newsapp

import retrofit.http.GET
import retrofit.Call

interface ApiService {

    @GET("jokes/random")
    fun getJokes(): Call<JocksDataModel>

}