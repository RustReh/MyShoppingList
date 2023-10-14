package com.example.myshoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.myshoppinglist.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MainActiv", it.toString())

                val item = it[1]
                viewModel.removeShopItem(item)

        }
    }
}