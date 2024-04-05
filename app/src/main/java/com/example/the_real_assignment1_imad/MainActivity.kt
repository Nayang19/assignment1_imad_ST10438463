package com.example.the_real_assignment1_imad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textResults)
        textInput = findViewById(R.id.editTextNumber)
        val clickMeButton: Button = findViewById(R.id.generateHistoryButton)
        val clearButton: Button = findViewById(R.id.clearButton)

        clickMeButton.setOnClickListener {
            val text: String = textInput.text.toString()
            var message = ""

            val number = text.toIntOrNull()
            if (number != null) {
                message = getMessageForNumber(number)
            } else {
                message = "Invalid input. Please enter a valid number."
            }

            appendToHistory(message)
        }

        clearButton.setOnClickListener {
            clearHistory()
        }
    }

    private fun getMessageForNumber(number: Int): String {
        return when (number) {
            in 20..26 -> "Celebrity Aaliyah was a famous RnB singer who passed away on August 25th 2001 due to a fatal plane crash."
            in 27..34 -> "Costa Titch was a famous South Africa rapper who passed away on 11th March 2023 at the age of 27."
            in 35..39 -> "Aka was a famous South African rapper who passed away on the 10th of February 2023 at the age of 35."
            in 40..49 -> "Paul Walker was a famous American actor who passed away 30th November 2013 at age 40 due to a car accident."
            in 50..52 -> "Michael Jackson, best known as the king of pop, was a famous American artist who passed away June 25th 2009 at age 50"
            in 53..59 -> "British singer and producer, George Michael passed away 25 December 2016 at the age of 53."
            in 60..65 -> "Diego Maradona was a famous Argentinian football player who passed away at age 60 on the 25th of November 2020"
            in 66..80 -> "Issac Hayes was a famous American actor and singer who passed away on August 10th 2008 at age 66."
            in 81..89 -> "Anti- Apartheid activist Winnie Mandela passed away at age 81 on the 2nd of April 2018."
            in 90..98 -> "Human rights activist Desmond Tutu passed away on 26 December 2021 at age 90."
            in 99..100 -> "Mike Nussbaum is an American actor and director who passed away on December 23 2023 at the age of 99"
            else -> "No information available for this number."
        }
    }

    private fun appendToHistory(message: String) {
        val currentText = textView.text.toString()
        val newText = if (currentText.isEmpty()) message else "$currentText\n$message"
        textView.text = newText
    }

    private fun clearHistory() {
        textView.text = ""
    }
}
