package com.faixeda.tip

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.faixeda.tip.databinding.ActivityMainBinding
import kotlin.math.ceil
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.calculateButton.setOnClickListener {
            if (binding.costOfService.text.toString().isEmpty()){
                binding.tipResult.text = ""
            } else {
                val price =  binding.costOfService.text.toString().toDouble()
                if (binding.optionTwentyPercent.isChecked){
                    var calculTip = price * 0.20
                    var totalPrice = calculTip + price
                    if (binding.roundUpSwitch.isChecked){
                        totalPrice = ceil(totalPrice)
                        binding.tipResult.text = "The total price is:  $totalPrice"
                    } else {
                        totalPrice = String.format("%.2f", totalPrice).toDouble()
                        binding.tipResult.text = "The total price is:  $totalPrice"
                    }
                } else if (binding.optionEighteenPercent.isChecked){
                    val calculTip : Double = price * 0.18
                    var totalPrice : Double = calculTip + price
                    if (binding.roundUpSwitch.isChecked){
                        totalPrice = ceil(totalPrice)
                        binding.tipResult.text = "The total price is:  $totalPrice"
                    } else {
                        totalPrice = String.format("%.2f", totalPrice).toDouble()
                        binding.tipResult.text = "The total price is:  $totalPrice"
                    }
                } else {
                    val calculTip : Double = price * 0.15
                    var totalPrice : Double = calculTip + price
                    if (binding.roundUpSwitch.isChecked){
                        totalPrice = ceil(totalPrice)
                        binding.tipResult.text = "The total price is:  $totalPrice"
                    } else {
                        totalPrice = String.format("%.2f", totalPrice).toDouble()
                        binding.tipResult.text = "The total price is:  $totalPrice"
                    }
                }
            }
        }
    }
}