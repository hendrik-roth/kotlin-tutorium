package com.example.api

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.cio.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            launch {
                val client = HttpClient()
                val response: Response = client.get("https://api.corona-zahlen.org/germany")
                Log.d("response", response.statusText.toString())
            }
        }
    }
}