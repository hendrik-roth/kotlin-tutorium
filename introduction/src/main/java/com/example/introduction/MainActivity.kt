package com.example.introduction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button //Damit der Button implementiert werden kann
import android.widget.TextView //Damit die TextView implementiert werden kann

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Buttons mittels vergebener ID aus dem Layout
        //siehe zeile 21 in /res/layout/activity_main.xml
        val clickeMe: Button = findViewById(R.id.clickMe)

        //TextView mittels vergebener ID aus dem Layout
        //siehe zeile 10 in /res/layout/activity_main.xml
        val counterView: TextView = findViewById(R.id.counterView)

        //veränderbaren (var) counter erstellen mit Wert 0 (Man fängt von 0 an zu zählen) und zuweisen
        var counter: Int = 0
        counterView.text = counter.toString() //toString() da erwarteter Datentyp ein String und kein Int ist

        //Mit Klick auf den Button erhöht sich der Zähler um 1.
        clickeMe.setOnClickListener {
            counter += 1
            counterView.text = counter.toString()
        }

        //alternative Methode um Button einzubinden
        val bringMeToSecond = findViewById<Button>(R.id.bringMeToSecond)

        //Aufruf der SecondActivity
        bringMeToSecond.setOnClickListener {
            //activity mit Kontext in 'Intent' verpacken
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
}