package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var nBinding: ActivityMainBinding?= null
    private val binding get() = nBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        nBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val height_text = binding.heightTextView
        val weight_text = binding.weightTextView
        val submit_button = binding.submitbutton

        submit_button.setOnClickListener {
            if (height_text.text.isEmpty()){
                Toast.makeText(this, "Height is Empty!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (weight_text.text.isEmpty()){
                Toast.makeText(this, "Weight is Empty!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val height: Float = height_text.text.toString().toFloat()
            val weight: Float = weight_text.text.toString().toFloat()

            val intent = Intent(this, ResultView::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)
        }
    }
}