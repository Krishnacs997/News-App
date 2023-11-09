package com.example.newsapp

import java.io.Serializable

data class newsResult(
    var totalResults: Int,
    var articles: ArrayList<NewsArrayModel>
): Serializable
data class NewsArrayModel(
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var content: String
): Serializable

data class JocksDataModel(
    var categoories:ArrayList<String>,
    var created_at: String,
    var icon_url:String,
    var id:String,
    var updated_at:String,
    var url:String,
    var value:String
): Serializable
