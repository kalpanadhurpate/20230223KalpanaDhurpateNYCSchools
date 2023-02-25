package com.example.kalpanadhurpate_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kalpanadhurpate_nycschools.R
import com.example.kalpanadhurpate_nycschools.SchoolApplication
import com.example.kalpanadhurpate_nycschools.adapter.RecyclerViewAdapter
import com.example.kalpanadhurpate_nycschools.model.SchoolListItem
import com.example.kalpanadhurpate_nycschools.viewmodel.SchoolListViewModelFactory
import com.example.kalpanadhurpate_nycschools.viewmodel.SchoolViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var schoolViewModel: SchoolViewModel
    private lateinit var adapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.CollegeNamesRecyclerView)
        recyclerView.setHasFixedSize(true)
        val repository = (application as SchoolApplication).schoolRepository
        //viewmodel instance
        schoolViewModel = ViewModelProvider(
            this,
            SchoolListViewModelFactory(repository)
        )[SchoolViewModel::class.java]

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter

        //activity observe school list data
        schoolViewModel.schools.observe(this) {
            adapter.updateMovieList(it)
        }
       //show school details
        adapter.onItemClick = {
            SchoolDetailFragment.newInstance(
                it.school_name,
                "Math Score: " + it.sat_math_avg_score,
                "Reading Score: " + it.sat_critical_reading_avg_score,
                "Writing Score: " + it.sat_writing_avg_score
            )
                .show(supportFragmentManager, SchoolDetailFragment.TAG)
        }
    }

}
