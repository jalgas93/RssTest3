package com.example.rsstest3.presentations.firstFrontFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.rsstest3.AllViewModel.AllViewModel
import com.example.rsstest3.repository.Repository

class AddChannelFactory(val repository: Repository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AllViewModel(repository) as T
    }
}