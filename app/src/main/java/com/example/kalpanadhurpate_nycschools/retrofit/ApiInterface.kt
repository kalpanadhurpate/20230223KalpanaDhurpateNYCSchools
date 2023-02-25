package com.example.kalpanadhurpate_nycschools.retrofit

import com.example.kalpanadhurpate_nycschools.pojo.SchoolListPojo
import com.example.kalpanadhurpate_nycschools.pojo.SchoolListPojoItem
import retrofit2.Response
import retrofit2.http.GET


interface ApiInterface {
    @GET("resource/f9bf-2cp4.json")
    suspend fun getSchoolList():Response<SchoolListPojo>
}