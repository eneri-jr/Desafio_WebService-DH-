package com.example.dhmarvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dhmarvel.R
import com.example.dhmarvel.service.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<MainViewModel>{
        object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    lateinit var adapterHq: AdapterHq
    lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterHq = AdapterHq()
        layoutManager = GridLayoutManager(this, 3)
        rcMain.adapter = adapterHq
        rcMain.layoutManager = layoutManager
        rcMain.hasFixedSize()

        viewModel.popListHqs()

        viewModel.listHqs.observe(this){
            adapterHq.addList(it)
        }
    }

}