package com.example.dhmarvel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dhmarvel.R
import com.example.dhmarvel.entities.Date
import com.example.dhmarvel.entities.Hq
import kotlinx.android.synthetic.main.activity_hq.*
import kotlinx.android.synthetic.main.card_login.*
import java.text.SimpleDateFormat
import java.util.*

class HqActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hq)

        setSupportActionBar(hqToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val hq = intent.getSerializableExtra("hq") as Hq

        val dateHq = hq.dates[0].date
        val data: java.util.Date? = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateHq)
        val dateHqFinal = SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(data)

        tvTitulo.text = hq.title
        tvDesc.text = hq.description
        tvPag.text = hq.pageCount.toString()
        tvPubli.text = dateHqFinal
        tvPrice.text = hq.prices[0].price.toString()

        var pathImages = hq.images[0].path
        var extImages = hq.images[0].extension
        Glide.with(this).asBitmap()
                .load("${pathImages}.${extImages}")
                .into(ivToolbar)
        Glide.with(this).asBitmap()
                .load("${pathImages}.${extImages}")
                .into(ivHqCapa)

        ivHqCapa.setOnClickListener(){
            val img = pathImages+"."+extImages
            val intent = Intent(this@HqActivity, CapaActivity::class.java).putExtra("img", img)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}