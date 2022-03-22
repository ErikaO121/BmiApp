package com.example.bmiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlin.math.nextTowards

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Idの取得
        val height: EditText = findViewById<EditText>(R.id.height)
        val weight: EditText = findViewById<EditText>(R.id.weight)
        val calcBtn: Button = findViewById<Button>(R.id.calcBtn)
        val tvAns: TextView = findViewById<TextView>(R.id.tvAns)
        val clearBtn: Button = findViewById<Button>(R.id.clearBtn)

        val bmiType = arrayOf("低体重(痩せ型)", "普通体重", "肥満(1度)", "肥満(2度)", "肥満(3度)", "肥満(4度)")


        fun calcBMI(h: Float, w: Float): String {


            val bmi: Float = (w / (h * h))

            //BMI区分(日本)
            val retVal: String = if (bmi < 18.5) {
                bmiType[0]
            } else if (bmi >= 18.5 && bmi < 25.0) {
                bmiType[1]
            } else if (bmi >= 25.0 && bmi < 30.0) {
                bmiType[2]
            } else if (bmi >= 30.0 && bmi < 35.0) {
                bmiType[3]
            } else if (bmi >= 18.5 && bmi < 25.0) {
                bmiType[4]
            } else {
                bmiType[5]
            }
            return retVal
        }

        calcBtn.setOnClickListener() {
            val heightInt = height.text.toString().toInt()
            val heightFloat: Float = (heightInt.toFloat() / 100)
            val weightInt = weight.text.toString().toInt()
            var weightFloat: Float = weightInt.toFloat()
            var ans = calcBMI(heightFloat, weightFloat)
            tvAns.text = ans
        }




        clearBtn.setOnClickListener() {
            height.text.clear()
            weight.text.clear()
            tvAns.text = "結果"
        }


    }


}