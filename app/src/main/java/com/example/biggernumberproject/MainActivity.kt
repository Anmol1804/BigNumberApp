package com.example.biggernumberproject

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.biggernumberproject.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // main todo
        assignNumbersToButtons()
        binding.btnLeft.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }

        binding.btnRight.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val num1 = r.nextInt(10)
        var num2 = num1
        while (num2 == num1) {
            num2 = r.nextInt(10)
        }
        binding.btnLeft.text = "$num1"
        binding.btnRight.text = "$num2"
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val n1 = binding.btnLeft.text.toString().toInt()
        val n2 = binding.btnRight.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) n1 > n2 else n2 > n1
        val toastMessage: String
        val backgroundColor: Int
        if (isAnswerCorrect) {
            toastMessage = "Correct!!"
            backgroundColor = Color.GREEN
        } else {
            toastMessage = "Wrong"
            backgroundColor = Color.RED
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        binding.backgroundView.setBackgroundColor(backgroundColor)
    }
}