package com.friday.joo.happybirthday.data

import com.friday.joo.happybirthday.Birthdayee

interface DataSource {

    fun getBirthdayees(): List<Birthdayee>

    fun addBirthDayee(birthDayee: Birthdayee)

}