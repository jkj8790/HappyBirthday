package com.friday.joo.happybirthday

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.friday.joo.happybirthday.data.BirthdayeeRepository
import com.friday.joo.happybirthday.data.MemoryCache

import kotlinx.android.synthetic.main.activity_add_person.*
import java.text.ParseException
import java.text.SimpleDateFormat

class AddPersonActivity : AppCompatActivity() {

    lateinit var repository: BirthdayeeRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_person)

        repository = BirthdayeeRepository(this)
        val dateFormat = SimpleDateFormat("yyyy-MM-dd")

        birthDayEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                try {
                    dateFormat.parse(p0.toString())
                    birthDayInputLayout.error = null
                } catch (e: ParseException) {
                    e.printStackTrace()
                    birthDayInputLayout.error = "생일 포맷이 이상합니다."
                }
            }
        })

        // 날짜를 밀리세컨드로 바꾸고, csv에 저장
        okButton.setOnClickListener {
            try {
                dateFormat.parse(birthDayEditText.text.toString())
                birthDayInputLayout.error = null

                val time = dateFormat.parse(birthDayEditText.text.toString()).time
                val name = nameEditText.text.toString()

                repository.addBirthDayee(Birthdayee(name, time, ""))
                Toast.makeText(this@AddPersonActivity, "저장 완료", Toast.LENGTH_SHORT).show()
                finish()
            } catch (e: ParseException) {
                e.printStackTrace()
                birthDayInputLayout.error = "생일 포맷이 이상합니다."
            }
        }

    }

}
