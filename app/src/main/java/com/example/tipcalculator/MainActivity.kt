package com.example.tipcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calBtn.setOnClickListener { calculate() }

    }
    @SuppressLint("ResourceType")
    fun calculate(){
        var enteredCost =binding.serviceCost.text.toString()
        var cost = enteredCost.toDoubleOrNull()
        if (cost ==null){
            binding.tipAmount.text=""
            return
        }
        val selectedId = binding.radioGroup.checkedRadioButtonId
        val tipPercent = when (selectedId){
R.id.amazingButton->.2
            R.id.goodButton->.18
            else->.15
        }
        var tipValue = cost*tipPercent
        if(binding.roundingSwitch.isChecked){
            tipValue= ceil(tipValue)
        }
        val formatedTip = NumberFormat.getCurrencyInstance().format(tipValue)
        binding.tipAmount.text=getString(R.string.tip_amount, formatedTip)



    }
}