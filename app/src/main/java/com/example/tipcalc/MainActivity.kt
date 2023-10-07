package com.example.tipcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton = findViewById<Button>(R.id.calculateButton)
        calculateButton.setOnClickListener{
            showResult()
        }
    }

    private fun calculateTip(): Double {
        val mealPriceText = findViewById<EditText>(R.id.inputCost)
        val tipPercentText = findViewById<EditText>(R.id.tipInput)
        val numPeopleText = findViewById<EditText>(R.id.peopleInput)

        val mealPrice = mealPriceText.text.toString().toDouble()
        val tipPercent = tipPercentText.text.toString().toDouble()
        val numPeople = numPeopleText.text.toString().toDouble()

        val tipAmount = (mealPrice * (tipPercent / 100)) / numPeople
        return(tipAmount)
    }

    private fun calculateTotal(): Double {
        val mealPriceText = findViewById<EditText>(R.id.inputCost)
        val tipPercentText = findViewById<EditText>(R.id.tipInput)
        val numPeopleText = findViewById<EditText>(R.id.peopleInput)

        val mealPrice = mealPriceText.text.toString().toDouble()
        val tipPercent = tipPercentText.text.toString().toDouble()
        val numPeople = numPeopleText.text.toString().toDouble()

        val totalAmount = mealPrice + (mealPrice * (tipPercent / 100) /  numPeople)

        return(totalAmount)
    }

    private fun showResult() {
        val tipTotal = calculateTip()
        val mealTotal = calculateTotal()
        val tipTotalText = findViewById<TextView>(R.id.result)
        val mealTxt = findViewById<TextView>(R.id.totalMeal)

        val resultText = "%.2f".format(tipTotal)
        val resultText2 = "%.2f".format(mealTotal)

        tipTotalText.text = "$ " + resultText
        mealTxt.text = "$ " + resultText2

    }

}