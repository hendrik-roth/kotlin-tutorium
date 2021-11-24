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
    private var textViewDeaths: TextView? = null
    private var mQueue: RequestQueue? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextViewResult = findViewById(R.id.text_view_result)

        textViewDeaths = findViewById(R.id.tv_deaths)
        val buttonParse = findViewById<Button>(R.id.button_parse)
        mQueue = Volley.newRequestQueue(this)

        showDeaths()
        mQueue?.start()

        buttonParse.setOnClickListener { getCases() }
    }

    private fun showDeaths() {
        val url = "https://api.corona-zahlen.org/germany"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val deaths = response.get("deaths")
                val format = java.text.NumberFormat.getIntegerInstance().format(deaths.toString().toInt()).replace(",", ".")
                val resultText = "Tode: $format"
                textViewDeaths?.text = resultText

            }, { error -> error.printStackTrace() })
        mQueue?.add(request)
    }

    private fun getCases() {
        val url = "https://api.corona-zahlen.org/germany"
        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val cases = response.get("cases")
                val format = java.text.NumberFormat.getIntegerInstance().format(cases.toString().toInt()).replace(",", ".")
                val result = "Anzahl Fälle insgesamt: $format"
                mTextViewResult?.text = result

            }, { error -> error.printStackTrace() })
        mQueue?.add(request)
    }
}