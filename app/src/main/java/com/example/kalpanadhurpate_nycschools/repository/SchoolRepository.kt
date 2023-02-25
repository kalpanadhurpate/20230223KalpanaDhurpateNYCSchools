package com.example.kalpanadhurpate_nycschools.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kalpanadhurpate_nycschools.model.SchoolList
import com.example.kalpanadhurpate_nycschools.api.ApiInterface

class SchoolRepository(private val apiInterface: ApiInterface) {

    private val schoolLiveData = MutableLiveData<SchoolList>()
    val schoolList: LiveData<SchoolList>
        get() = schoolLiveData

    suspend fun getSchoolList() {
        //call api to get school list
        val result = apiInterface.getSchoolList()
        if (result.body() != null) {
            Log.i("Data:", result.body().toString())
            schoolLiveData.postValue(result.body())

        }

    }

}