package com.friday.joo.happybirthday

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.LinearLayoutManager
import com.friday.joo.happybirthday.data.BirthdayeeRepository
import com.friday.joo.happybirthday.data.MemoryCache
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    lateinit var birthdayeeRepository: BirthdayeeRepository
    lateinit var birthdayeeAdapter: BirthdayeeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        birthdayeeRepository = BirthdayeeRepository(this)
        birthdayeeAdapter = BirthdayeeAdapter(emptyList())

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = birthdayeeAdapter

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->

            startActivity(Intent(this, AddPersonActivity::class.java))

            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawerLayout.closeDrawers()

            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }
    }

    override fun onResume() {
        super.onResume()

        birthdayeeAdapter.birthdayeeList = birthdayeeRepository.getBirthdayees()
        birthdayeeAdapter.notifyDataSetChanged()
    }
}
