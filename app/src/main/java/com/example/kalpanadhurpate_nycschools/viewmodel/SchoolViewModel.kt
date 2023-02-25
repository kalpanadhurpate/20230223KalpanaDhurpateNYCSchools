package com.example.kalpanadhurpate_nycschools.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kalpanadhurpate_nycschools.model.SchoolList
import com.example.kalpanadhurpate_nycschools.repository.SchoolRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SchoolViewModel(private val repository: SchoolRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getSchoolList()
        }
    }

    val schools: LiveData<SchoolList>
    get() = repository.schoolList
}