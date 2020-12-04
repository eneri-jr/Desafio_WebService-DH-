package com.example.dhmarvel.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dhmarvel.R
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.card_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setSupportActionBar(toolbar)

        btnSave.setOnClickListener() {
            val intent = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}