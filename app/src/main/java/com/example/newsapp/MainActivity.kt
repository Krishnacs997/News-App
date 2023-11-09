package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonJocks.setOnClickListener{
            ApiCall().getJokese(this){ it1 ->
                Log.d("Joke API Responce", it1.toString())
                binding.textViewJ.text = it1.value
            }
        }

        binding.buttonGetNews.setOnClickListener{
            ApiCall().getNews(this){it2 ->
                Log.d("News API Responce", it2.toString())
            }
        }
    }
}