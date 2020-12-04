package com.example.dhmarvel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dhmarvel.R
import com.example.dhmarvel.service.repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HqAdapter.OnclickHqListener {

    val viewModel by viewModels<MainViewModel>{
        object: ViewModelProvider.Factory{
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    lateinit var hqAdapter: HqAdapter
    lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hqAdapter = HqAdapter(this)
        layoutManager = GridLayoutManager(this, 3)
        rcMain.adapter = hqAdapter
        rcMain.layoutManager = layoutManager
        rcMain.hasFixedSize()

        viewModel.popListHqs()

        viewModel.listHqs.observe(this){
            hqAdapter.addList(it)
        }
    }

    override fun onClickHq(position: Int) {
        var hq = hqAdapter.listHq[position]
        val intent = Intent(this@MainActivity, HqActivity::class.java).putExtra("hq", hq)
        startActivity(intent)
    }

}