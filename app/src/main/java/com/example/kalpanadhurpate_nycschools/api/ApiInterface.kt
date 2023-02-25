package com.example.kalpanadhurpate_nycschools.api

import com.example.kalpanadhurpate_nycschools.model.SchoolList
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    //service call to get data
    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolList():Response<SchoolList>
}