package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OutputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val txt = findViewById<TextView>(R.id.tipResult)
        intent = getIntent()
        val output = intent.getStringExtra("amount")
        txt.text = output
    }
}