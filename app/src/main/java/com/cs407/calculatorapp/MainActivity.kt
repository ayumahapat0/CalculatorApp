package com.cs407.calculatorapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val operandOne = findViewById<EditText>(R.id.operandOne)
        val operandTwo = findViewById<EditText>(R.id.operandTwo)

        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)
        val multiplyButton = findViewById<Button>(R.id.multiplyButton)
        val divideButton = findViewById<Button>(R.id.divisionButton)

        val intent = Intent(this, CalculatorResult::class.java)


        // Add Button handler
        addButton.setOnClickListener(){
            val num1 = operandOne.text.toString().toInt()
            val num2 = operandTwo.text.toString().toInt()
            var result = num1 + num2
            intent.putExtra("EXTRA_MESSAGE", result.toString())
            startActivity(intent)

        }

        // Subtract Button handler
        subtractButton.setOnClickListener(){
            val num1 = operandOne.text.toString().toInt()
            val num2 = operandTwo.text.toString().toInt()
            val result = num1 - num2
            intent.putExtra("EXTRA_MESSAGE", result.toString())
            startActivity(intent)
        }

        // Multiply Button handler
        multiplyButton.setOnClickListener(){
            val num1 = operandOne.text.toString().toInt()
            val num2 = operandTwo.text.toString().toInt()
            val result = num1 * num2
            intent.putExtra("EXTRA_MESSAGE", result.toString())
            startActivity(intent)
        }

        // Divide Button handler
        divideButton.setOnClickListener(){
            val num1 = operandOne.text.toString().toInt()
            val num2 = operandTwo.text.toString().toInt()
            if (num2 == 0){
                val result = "Can't divide a number by zero"
                intent.putExtra("EXTRA_MESSAGE", result)
            }
            else{
                val result = num1.toDouble() / num2
                intent.putExtra("EXTRA_MESSAGE", result.toString())
            }
            startActivity(intent)
        }
    }
}