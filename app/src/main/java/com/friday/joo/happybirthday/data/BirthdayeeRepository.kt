package com.friday.joo.happybirthday.data

import android.content.Context
import com.friday.joo.happybirthday.BirhdayParser
import com.friday.joo.happybirthday.Birthdayee
import com.friday.joo.happybirthday.R
import java.io.BufferedReader
import java.io.InputStreamReader

class BirthdayeeRepository(
        context: Context
) : DataSource {
    private val csvDataSource = CsvDataSource(context)
    private val memoryDataSource = MemoryCache

    // Room 으로 DB넣기~~~

    override fun getBirthdayees(): List<Birthdayee> {
        return csvDataSource.getBirthdayees() + memoryDataSource.getBirthdayees()
    }

    override fun addBirthDayee(birthDayee: Birthdayee) {
        memoryDataSource.addBirthDayee(birthDayee)
    }
}