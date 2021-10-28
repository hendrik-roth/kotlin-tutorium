package com.example.introduction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    //Neue Activities müssen in
    // /manifest/AndroidManifest.xml (s. Zeile 20-22) eingetragen werden
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bringMeToMain: Button = findViewById(R.id.bringMeToMain)

        bringMeToMain.setOnClickListener {
            //Intent(context, ZielActivity::class.java)
            val intent = Intent(this, MainActivity::class.java)
            //startet die Activity die in 'intent' angegeben wurde
            startActivity(intent)
        }
    }
}