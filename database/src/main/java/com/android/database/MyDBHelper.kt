package com.android.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, "USER", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createStatement = "CREATE TABLE USER (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EMAIL STRING NOT NULL, " +
                "PW STRING NOT NULL)"
        db?.execSQL(createStatement)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}