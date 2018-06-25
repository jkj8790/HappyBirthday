package com.friday.joo.happybirthday

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.friday.joo.happybirthday.data.BirthdayeeRepository

class MainViewModel(
        private val repository: BirthdayeeRepository
): ViewModel() {
    val birthdayeeLiveData: MutableLiveData<List<Birthdayee>> = MutableLiveData()

    get() {
        if(field.value == null) {
            field.value = repository.getBirthdayees()
        }
        return field
    }

    fun sync() {
        birthdayeeLiveData.value = repository.getBirthdayees()
    }
}