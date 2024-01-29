package com.example.mvvmcorurion.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmcorurion.model.jsonList
import com.example.mvvmcorurion.model.jsonListItem
import com.example.mvvmcorurion.repostory.jsonRepostory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private val repostory: jsonRepostory) : ViewModel() {

//    init {
//        viewModelScope.launch (Dispatchers.IO){
//            repostory.getJson(3)
//        }
//    }

    fun getjson(postId:Int) = viewModelScope.launch (Dispatchers.IO){
            repostory.getJson(postId)
        }

    fun pushPost(post: jsonListItem)=viewModelScope.launch (Dispatchers.IO){
        repostory.pushPost(post)
    }

    val jsons:LiveData<jsonList>
        get() = repostory.jsons


    val jsons1:LiveData<jsonListItem>
        get() = repostory.jsons1

}