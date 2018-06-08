package com.friday.joo.happybirthday.data

import android.content.Context
import com.friday.joo.happybirthday.BirhdayParser
import com.friday.joo.happybirthday.Birthdayee
import com.friday.joo.happybirthday.R
import java.io.BufferedReader
import java.io.InputStreamReader

class CsvDataSource(
        private val context: Context
): DataSource {
    override fun getBirthdayees(): List<Birthdayee> {
        val input = context.resources.openRawResource(R.raw.birthday)
        val inputStream = BufferedReader(InputStreamReader(input, "UTF8"))
        return BirhdayParser().parseFile(inputStream)
    }

    override fun addBirthDayee(birthDayee: Birthdayee) {
        throw NotImplementedError()
    }
}