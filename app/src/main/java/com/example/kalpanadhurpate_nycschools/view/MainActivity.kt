package com.example.kalpanadhurpate_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalpanadhurpate_nycschools.R
import com.example.kalpanadhurpate_nycschools.SchoolApplication
import com.example.kalpanadhurpate_nycschools.adapter.RecyclerViewAdapter
import com.example.kalpanadhurpate_nycschools.data.CollegeNames
import com.example.kalpanadhurpate_nycschools.pojo.SchoolListPojoItem
import com.example.kalpanadhurpate_nycschools.viewmodel.SchoolListViewModelFactory
import com.example.kalpanadhurpate_nycschools.viewmodel.SchoolViewModel

class MainActivity : AppCompatActivity() {
    private var schoolList = listOf<SchoolListPojoItem>()
    private lateinit var schoolViewModel: SchoolViewModel
    private lateinit var adapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.CollegeNamesRecyclerView)
        recyclerView.setHasFixedSize(true)
        val repository = (application as SchoolApplication).schoolRepository
        schoolViewModel = ViewModelProvider(
            this,
            SchoolListViewModelFactory(repository)
        )[SchoolViewModel::class.java]

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        schoolViewModel.schools.observe(this) {
            Log.i("got service response: ", it.toString())
            adapter.updateMovieList(it)
        }
        adapter.onItemClick = {
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            SATScore().show(supportFragmentManager, "MyCustomFragment")
        }

    }
}