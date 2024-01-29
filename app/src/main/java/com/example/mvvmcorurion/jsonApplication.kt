package com.example.mvvmcorurion

import android.app.Application
import com.example.mvvmcorurion.api.JsonService
import com.example.mvvmcorurion.api.RetrofitHelper
import com.example.mvvmcorurion.repostory.jsonRepostory

class jsonApplication : Application() {

    lateinit var jsonepostory: jsonRepostory
    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val jsonService = RetrofitHelper.getInstance().create(JsonService::class.java)
        jsonepostory = jsonRepostory(jsonService)
    }
}

