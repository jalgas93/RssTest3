package com.example.rsstest3.presentations.frontFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rsstest3.AllViewModel.AllViewModel
import com.example.rsstest3.repository.Repository

class FrontViewModelFactory(var repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllViewModel(repository = repository) as T
    }
}