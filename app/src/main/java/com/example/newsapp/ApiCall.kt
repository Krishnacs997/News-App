package com.example.newsapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class ApiCall {
    fun getJokese(context: Context, callback: (JocksDataModel)-> Unit){
        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://api.chucknorris.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val apiService: ApiService = retrofit.create<ApiService>(ApiService::class.java)

        val call: Call<JocksDataModel> = apiService.getJokes()

        call.enqueue(object : Callback<JocksDataModel>{
            override fun onResponse(response: Response<JocksDataModel>?, retrofit: Retrofit?) {
                if (response!!.isSuccess){
                    val jokes : JocksDataModel = response.body() as JocksDataModel
                    callback(jokes)
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Request failed", Toast.LENGTH_SHORT).show()
            }

        })
    }

    fun getNews(context: Context, callback: (newsResult) -> Unit){
        val newsRerofit: Retrofit = Retrofit.Builder().baseUrl("https://newsapi.org/").addConverterFactory(GsonConverterFactory.create()).build()

        val apiNewsSer: ApiService = newsRerofit.create<ApiService>(ApiService::class.java)
        val call: Call<newsResult> = apiNewsSer.getNewsList()

        call.enqueue(object : Callback<newsResult>{
            override fun onResponse(response: Response<newsResult>?, retrofit: Retrofit?) {
                if (response!!.isSuccess){
                    Log.d("TAG", response.body().toString())
                    val newsList : newsResult = response.body() as newsResult
                    callback(newsList)
                }
            }

            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Request failed", Toast.LENGTH_SHORT).show()
            }

        })
    }
}