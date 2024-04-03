package com.example.historyapp

//Taahir Hoosen
//ST10445196
//YouTube link-

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
            95 -> "Nelson Mandela - Fought against apartheid in South Africa, becoming the country's first black president."
            90 -> "Desmond Tutu - Archbishop and human rights activist who played a significant role in ending apartheid in South Africa."
            81 -> "Winnie Mandela - Anti-apartheid activist and politician, known for her resilience and activism alongside Nelson Mandela."
            30 -> "Steve Biko - Prominent anti-apartheid activist and founder of the Black Consciousness Movement in South Africa."
            76 -> "Miriam Makeba - Renowned South African singer and civil rights activist, known as Mama Africa."
            84 -> "Thomas Edison - Prolific American inventor, known for inventions such as the phonograph and the practical electric light bulb."
            75 -> "Alexander Graham Bell -  Scottish-born inventor, credited with inventing the telephone."
            86 -> "Nikola Tesla -  Serbian-American inventor and electrical engineer, known for his contributions to alternating current electricity."
            67 -> "Leonardo da Vinci - Italian polymath, renowned for his artistic masterpieces and groundbreaking scientific innovations."
            66 -> "Marie Curie - Polish-born physicist and chemist, famous for her pioneering research on radioactivity."
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