package com.example.historyapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //declare
    private lateinit var ageInput: EditText
    private lateinit var generateHistoryButton: Button
    private lateinit var clearButton: Button
    private lateinit var resultTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //initialise
        ageInput = findViewById(R.id.ageInput)
        generateHistoryButton = findViewById(R.id.generateHistoryButton)
        clearButton = findViewById(R.id.clearButton)
        resultTextView = findViewById(R.id.resultTextView)

        generateHistoryButton.setOnClickListener {
            generateHistory()
        }

        clearButton.setOnClickListener {
            clearInput()
        }
    }

    private fun generateHistory() {
        val ageText = ageInput.text.toString()
        if (ageText.isEmpty()) {
            resultTextView.text = "Please enter an age."
            return
        }

        val age = ageText.toIntOrNull()
        if (age == null) {
            resultTextView.text = "Invalid age format. Please enter a valid integer."
            return
        }

        if (age !in 20..100) {
            resultTextView.text = "Age must be between 20 and 100."
            return
        }

        val historicalFigure = when (age) {
            95 -> "Nelson Mandela"
            90 -> "Desmond Tutu"
            81 -> "Winnie Mandela"
            30 -> "Steve Biko"
            76 -> "Miriam Makeba"
            84 -> "Thomas Edison"
            75 -> "Alexander Graham Bell"
            86 -> "Nikola Tesla"
            67 -> "Leonardo da Vinci"
            66 -> "Marie Curie"
            else -> null
        }

        val message = if (historicalFigure != null) "The historical figure is $historicalFigure."
        else "No historical figure found with the entered age."
        resultTextView.text = message
    }

    private fun clearInput() {
        ageInput.text.clear()
        resultTextView.text = ""
    }
}