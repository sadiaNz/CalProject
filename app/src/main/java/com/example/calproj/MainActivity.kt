package com.example.calproj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calproj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.weightPicker.minValue = 30
        binding.weightPicker.maxValue = 150

        binding.heightPicker.minValue = 100
        binding.heightPicker.maxValue = 250


        binding.weightPicker.setOnValueChangedListener { _,_,_ ->
            calculateHealth()
        }

        binding.heightPicker.setOnValueChangedListener { _,_,_ ->
            calculateHealth()
        }
    }

    private fun calculateHealth()
    {
        val height = binding.heightPicker.value
        val doubleHeight= height.toDouble()/100

        val weight= binding.weightPicker.value

        val Health = weight.toDouble()/(doubleHeight * doubleHeight)

        binding.resultsTV.text = String.format("your Health is: %2f", Health)
        binding.healthyTV.text = String.format("Considered: %s", healthyMessage(Health))
    }


    private fun healthyMessage(Health: Double):String
    {
        
    }
}

