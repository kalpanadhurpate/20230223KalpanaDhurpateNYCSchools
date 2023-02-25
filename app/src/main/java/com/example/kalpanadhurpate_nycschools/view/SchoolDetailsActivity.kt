package com.example.kalpanadhurpate_nycschools.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kalpanadhurpate_nycschools.R

class SchoolDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_details)
        val bundle=intent.extras
        if(bundle!=null){

        }
    }
}