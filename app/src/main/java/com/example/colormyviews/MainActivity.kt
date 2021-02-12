package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.boxOne, binding.boxTwo, binding.boxThree, binding.boxFour, binding.boxFive, binding.constraintLayout, binding.redButton, binding.yellowButton, binding.greenButton
        )

        for (item in clickableViews) {
            item.setOnClickListener {
                makeColored(it)
            }
        }
    }

    fun makeColored(view: View) {
        when (view.id) {

            // Boxes using Color class colors for background
            R.id.boxOne -> view.setBackgroundColor(Color.DKGRAY)
            R.id.boxTwo -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.boxThree -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.boxFour -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.boxFive -> view.setBackgroundResource(android.R.color.holo_green_light)

            //Set box colors using buttons
            R.id.redButton -> binding.boxThree.setBackgroundColor(Color.RED)
            R.id.yellowButton -> binding.boxFour.setBackgroundColor(Color.YELLOW)
            R.id.greenButton -> binding.boxFive.setBackgroundColor(Color.GREEN)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}