package com.example.newsapp

data class NewsModel(
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var content: String
)

data class JocksDataModel(
    var categoories:ArrayList<String>,
    var created_at: String,
    var icon_url:String,
    var id:String,
    var updated_at:String,
    var url:String,
    var value:String
):java.io.Serializable
