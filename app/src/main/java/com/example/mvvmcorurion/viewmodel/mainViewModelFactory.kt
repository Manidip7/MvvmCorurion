package com.example.mvvmcorurion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcorurion.repostory.jsonRepostory

class mainViewModelFactory (private val repostory: jsonRepostory) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repostory)as T
    }
}