package com.example.mvvmcorurion.repostory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmcorurion.api.JsonService
import com.example.mvvmcorurion.model.jsonList
import com.example.mvvmcorurion.model.jsonListItem
import retrofit2.Response

class jsonRepostory(private val jsonService: JsonService) {

    private val jsonLiveData = MutableLiveData<jsonList>()
    val jsons: LiveData<jsonList>
        get() = jsonLiveData


    private val jsonLiveData2 = MutableLiveData<jsonListItem>()
    val jsons1: LiveData<jsonListItem>
        get() = jsonLiveData2


    suspend fun getJson(postId:Int){
        val result = jsonService.getJson(postId)
        if (result?.body() != null){
            jsonLiveData.postValue(result.body())
        }
    }

    suspend fun pushPost(post: jsonListItem){
        val result = jsonService.pushPost(post)
        if (result?.body() != null){
            jsonLiveData2.postValue(result.body())
        }
    }

}