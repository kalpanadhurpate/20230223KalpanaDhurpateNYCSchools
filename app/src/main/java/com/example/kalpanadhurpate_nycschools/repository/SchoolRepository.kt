package com.example.kalpanadhurpate_nycschools.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kalpanadhurpate_nycschools.model.SchoolList
import com.example.kalpanadhurpate_nycschools.api.ApiInterface

class SchoolRepository(
    private val apiInterface: ApiInterface,
    private val applicationContext: Context,
) {
    private val schoolLiveData = MutableLiveData<SchoolList>()
    val schoolList: LiveData<SchoolList>
    get() = schoolLiveData

    suspend fun getSchoolList() {
        val result = apiInterface.getSchoolList()
        Log.i("Data1:",result.toString())
        if (result.body() != null) {
            Log.i("Data:2",result.body().toString())

           schoolLiveData.postValue(result.body())

        }

    }

}