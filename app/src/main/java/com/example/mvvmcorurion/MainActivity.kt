package com.example.mvvmcorurion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmcorurion.adapter.QuoteAdapter
import com.example.mvvmcorurion.adapter.RecyclickviewClickListinor
import com.example.mvvmcorurion.api.JsonService
import com.example.mvvmcorurion.api.RetrofitHelper
import com.example.mvvmcorurion.model.jsonList
import com.example.mvvmcorurion.model.jsonListItem
import com.example.mvvmcorurion.repostory.jsonRepostory
import com.example.mvvmcorurion.viewmodel.MainViewModel
import com.example.mvvmcorurion.viewmodel.mainViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity(),RecyclickviewClickListinor {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var quoteAdapter: QuoteAdapter
    lateinit var recyclerView: RecyclerView
    lateinit var edt : EditText
    lateinit var btn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt = findViewById(R.id.edt)
        btn = findViewById(R.id.btn)
        recyclerView = findViewById(R.id.rec)
        btn.setOnClickListener {
            val page = edt.text.toString().trim().toInt()

            mainViewModel.getjson(page)
//            val mypost =  jsonListItem("Androis","hcdc",6,"Hi",8)
//            mainViewModel.pushPost(jsonListItem("Android Developer","Android@gmail.com",8,"Android",4))
        }
        val repository = (application as jsonApplication).jsonepostory

        mainViewModel = ViewModelProvider(this,mainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.jsons.observe(this, Observer {
//            Log.d("Hi" ,it.toString())

//            val productlist : TextView= it.toList()
//            val productlist= it.toList()

            quoteAdapter = QuoteAdapter(it.toList(),this)
            recyclerView.adapter = quoteAdapter
            recyclerView.layoutManager = LinearLayoutManager(this)

            
        })
    }

    override fun onRecycleViewItemClick(view: View, json: jsonListItem) {
        when(view.id){
            R.id.btn ->{
                Toast.makeText(this,json.name.toString(),Toast.LENGTH_LONG).show()

                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("title", json.name)
                startActivity(intent)
            }
        }
    }
}