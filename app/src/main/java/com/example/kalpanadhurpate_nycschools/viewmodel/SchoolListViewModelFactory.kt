package com.example.kalpanadhurpate_nycschools.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kalpanadhurpate_nycschools.repository.SchoolRepository

class SchoolListViewModelFactory(private val repository: SchoolRepository) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SchoolViewModel(repository) as T
    }

}