package com.example.dhmarvel.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dhmarvel.R
import com.example.dhmarvel.entities.Hq
import kotlinx.android.synthetic.main.activity_capa.*
import kotlinx.android.synthetic.main.activity_hq.*
import kotlinx.android.synthetic.main.activity_hq.hqToolbar
import kotlinx.android.synthetic.main.activity_hq.ivHqCapa

class CapaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capa)

        setSupportActionBar(hqToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val img = intent.getStringExtra("img").toString()

        Glide.with(this).asBitmap()
                .load(img)
                .into(ivCapa)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}