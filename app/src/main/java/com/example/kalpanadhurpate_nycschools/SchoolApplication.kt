package com.example.kalpanadhurpate_nycschools

import android.app.Application
import com.example.kalpanadhurpate_nycschools.repository.SchoolRepository
import com.example.kalpanadhurpate_nycschools.retrofit.ApiInterface
import com.example.kalpanadhurpate_nycschools.retrofit.RetrofitClient

class SchoolApplication : Application() {
    lateinit var schoolRepository: SchoolRepository
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {

        val apiInterface = RetrofitClient.getInstance().create(ApiInterface::class.java)
        //  val database = QuoteDatabase.getDatabase(applicationContext)
        schoolRepository = SchoolRepository(apiInterface, applicationContext)

    }

}