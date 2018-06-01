package com.friday.joo.happybirthday

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = resources.openRawResource(R.raw.birthday)

        val inputStream = BufferedReader(InputStreamReader(input, "UTF8"))

        val birthdayees = BirhdayParser().parseFile(inputStream)

        val adapter = BirthdayeeAdapter(birthdayees)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
