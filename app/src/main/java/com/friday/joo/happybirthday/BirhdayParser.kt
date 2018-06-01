package com.friday.joo.happybirthday

import java.io.BufferedReader

class BirhdayParser {

    fun parseFile(bufferedReader: BufferedReader): List<Birthdayee> {
        return bufferedReader.readLines()
                .map { it.split(",") }
                .map { Birthdayee(it[0], it[1].toLong(), it[2]) }
    }

}