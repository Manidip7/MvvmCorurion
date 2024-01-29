package com.example.mvvmcorurion.api

import com.example.mvvmcorurion.model.jsonList
import com.example.mvvmcorurion.model.jsonListItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface JsonService {

    @GET("/comments")
    suspend fun getJson(
        @Query("postId") postId:Int
    ) : Response<jsonList>

    @POST("posts")
    suspend fun pushPost(
        @Body post: jsonListItem
    ):Response<jsonListItem>
}
