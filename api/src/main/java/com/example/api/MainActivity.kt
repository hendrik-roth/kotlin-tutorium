package com.example.api

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley


class MainActivity : AppCompatActivity() {
    private var mTextViewResult: TextView? = null
    private var mQueue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextViewResult = findViewById(R.id.text_view_result)
        val buttonParse = findViewById<Button>(R.id.button_parse)

        mQueue = Volley.newRequestQueue(this)
        buttonParse.setOnClickListener { jsonParse() }
    }

    private fun jsonParse() {
        val url = "https://api.corona-zahlen.org/germany"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val cases = response.get("cases")
                val format = java.text.NumberFormat.getIntegerInstance().format(cases.toString().toInt()).replace(",", ".")

                mTextViewResult?.text = format

            }, { error -> error.printStackTrace() })
        mQueue?.add(request)
    }
}