package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.math.pow
import com.example.bmicalculator.databinding.ActivityResultViewBinding
import kotlin.math.round

class ResultView : AppCompatActivity() {

    private var nBinding: ActivityResultViewBinding?= null
    private val binding get() = nBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nBinding = ActivityResultViewBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val height = intent.getFloatExtra("height", 0f)
        val weight = intent.getFloatExtra("weight", 0f)

        val bmi = round((weight/((height/100.0f).pow(2.0f)))*100) /100

        val resultText = when{
            bmi >= 30.0 -> "Severe Obesity"
            bmi >= 25.0 -> "Mild Obesity"
            bmi >= 23.0 -> "OverWeight"
            bmi >= 18.5 -> "Normal Weight"
            else -> "UnderWeight"
        }

        val percentageText = when{
            bmi >= 22.0 -> "${round((bmi-22.0/22.0)*100)/100.toFloat()}% Higher"
            else -> "${round((22.0-bmi/22.0)*100)/100.toFloat()}% Lower"
        }

        val resultValueTextView = binding.BMIResultTextView
        val resultStringTextView = binding.ResultTextView
        val resultPercentageTextView = binding.percentageView

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
        resultPercentageTextView.text = percentageText

        val progressBar = binding.progressBar
        val percent = calculatePercent(bmi)

        progressBar.max = 100
        progressBar.progress = percent.toInt()

    }
    private fun calculatePercent(bmi: Float): Double {
        return (bmi-12.0)/(45.0-12.0)*100.0
    }
}