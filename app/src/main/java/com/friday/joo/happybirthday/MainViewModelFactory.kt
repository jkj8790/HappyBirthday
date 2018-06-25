package com.friday.joo.happybirthday

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.friday.joo.happybirthday.data.BirthdayeeRepository

class MainViewModelFactory(
        private val repository: BirthdayeeRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}