package com.friday.joo.happybirthday.data

import com.friday.joo.happybirthday.Birthdayee

object MemoryCache : DataSource {
    private val humans: MutableList<Birthdayee> = mutableListOf()

    override fun getBirthdayees(): List<Birthdayee> {
        return humans.toList()
    }

    override fun addBirthDayee(birthDayee: Birthdayee) {
        humans.add(Birthdayee(birthDayee.name, birthDayee.date, ""))
    }

}