package com.example.tiptime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calculateBtn = binding.calculateBtn
        calculateBtn.setOnClickListener {
            calculateTip()
        }
    }
        fun calculateTip(){
            val costStr = binding.enterCost2.text.toString()
            val cost = costStr.toDouble()

            val selectedId = binding.option.checkedRadioButtonId
            val percentage = when (selectedId){
                R.id.opt1_btn -> 0.2
                R.id.opt2_btn -> 0.15
                else -> 0.13
            }
            var tipAmount = cost*percentage

            val roundup = binding.TipSwitch.isChecked
            if(roundup)
                tipAmount = ceil(tipAmount)

            val formattedTip = NumberFormat.getCurrencyInstance().format(tipAmount)
            val output = "Tip Amount:" +formattedTip

            val intent = Intent(this, OutputActivity::class.java)
            intent.putExtra("amount",output)
            startActivity(intent)

        }
}