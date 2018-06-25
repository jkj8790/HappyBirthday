package com.friday.joo.happybirthday

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.friday.joo.happybirthday.data.BirthdayeeRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var birthdayeeAdapter: BirthdayeeAdapter
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        val birthdayeeRepository = BirthdayeeRepository(this) //Todo Make this singleton
        val viewModelFactory = MainViewModelFactory(birthdayeeRepository) //Todo Inject with Dagger
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(MainViewModel::class.java)
        viewModel.birthdayeeLiveData
                .observe(this, Observer<List<Birthdayee>> { birthdayeeList ->
                    birthdayeeList?.apply { //Todo impl with DataBinding
                        birthdayeeAdapter.birthdayeeList = this
                        birthdayeeAdapter.notifyDataSetChanged()
                    }
                })
    }

    private fun initUI() {
        birthdayeeAdapter = BirthdayeeAdapter(mutableListOf())

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

        viewModel.sync() //Todo move to onActivityResult
    }
}
