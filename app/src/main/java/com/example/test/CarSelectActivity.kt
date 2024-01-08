package com.example.test

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

class CarSelectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_select)
        var isSelected:Int =0
        val btn1 =findViewById<LinearLayout>(R.id.LinearLayoutButton1)
        val btn2 =findViewById<LinearLayout>(R.id.LinearLayoutButton2)
        val btn3 =findViewById<LinearLayout>(R.id.LinearLayoutButton3)
        val btn4 =findViewById<LinearLayout>(R.id.LinearLayoutButton4)
        val btn5 =findViewById<LinearLayout>(R.id.LinearLayoutButton5)
        val btn6 =findViewById<LinearLayout>(R.id.LinearLayoutButton6)
        btn1.setOnClickListener{ onLinearLayoutClick(btn1, isSelected) }
        btn2.setOnClickListener{ onLinearLayoutClick(btn2, isSelected) }
        btn3.setOnClickListener{ onLinearLayoutClick(btn3, isSelected) }
        btn4.setOnClickListener{ onLinearLayoutClick(btn4, isSelected) }
        btn5.setOnClickListener{ onLinearLayoutClick(btn5, isSelected) }
        btn6.setOnClickListener{ onLinearLayoutClick(btn6, isSelected) }
    }
    fun onLinearLayoutClick(linearLayout: LinearLayout, isSelected: Int) {
        val text1 = findViewById<TextView>(R.id.text1)
        val text2 = findViewById<TextView>(R.id.text2)
        val text3 = findViewById<TextView>(R.id.text3)
        val text4 = findViewById<TextView>(R.id.text4)
        val text5 = findViewById<TextView>(R.id.text5)
        val text6 = findViewById<TextView>(R.id.text6)
        val linearLayout1 = findViewById<LinearLayout>(R.id.LinearLayoutButton1)
        val linearLayout2 = findViewById<LinearLayout>(R.id.LinearLayoutButton2)
        val linearLayout3 = findViewById<LinearLayout>(R.id.LinearLayoutButton3)
        val linearLayout4 = findViewById<LinearLayout>(R.id.LinearLayoutButton4)
        val linearLayout5 = findViewById<LinearLayout>(R.id.LinearLayoutButton5)
        val linearLayout6 = findViewById<LinearLayout>(R.id.LinearLayoutButton6)
        when (linearLayout.id) {
            R.id.LinearLayoutButton1 -> {
                text1.setTextColor(Color.parseColor("#C2FF41"))
                text2.setTextColor(Color.parseColor("#ffffff"))
                text3.setTextColor(Color.parseColor("#ffffff"))
                text4.setTextColor(Color.parseColor("#ffffff"))
                text5.setTextColor(Color.parseColor("#ffffff"))
                text6.setTextColor(Color.parseColor("#ffffff"))
                linearLayout1.setBackgroundResource(R.drawable.rounded_corner_box_selected)
                linearLayout2.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout3.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout4.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout5.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout6.setBackgroundResource(R.drawable.rounded_corner_box)
            }
            R.id.LinearLayoutButton2 -> {
                text1.setTextColor(Color.parseColor("#ffffff"))
                text2.setTextColor(Color.parseColor("#C2FF41"))
                text3.setTextColor(Color.parseColor("#ffffff"))
                text4.setTextColor(Color.parseColor("#ffffff"))
                text5.setTextColor(Color.parseColor("#ffffff"))
                text6.setTextColor(Color.parseColor("#ffffff"))
                linearLayout1.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout2.setBackgroundResource(R.drawable.rounded_corner_box_selected)
                linearLayout3.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout4.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout5.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout6.setBackgroundResource(R.drawable.rounded_corner_box)

            }
            R.id.LinearLayoutButton3 -> {
                text1.setTextColor(Color.parseColor("#ffffff"))
                text2.setTextColor(Color.parseColor("#ffffff"))
                text3.setTextColor(Color.parseColor("#C2FF41"))
                text4.setTextColor(Color.parseColor("#ffffff"))
                text5.setTextColor(Color.parseColor("#ffffff"))
                text6.setTextColor(Color.parseColor("#ffffff"))
                linearLayout1.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout2.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout3.setBackgroundResource(R.drawable.rounded_corner_box_selected)
                linearLayout4.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout5.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout6.setBackgroundResource(R.drawable.rounded_corner_box)

            }
            R.id.LinearLayoutButton4 -> {
                text1.setTextColor(Color.parseColor("#ffffff"))
                text2.setTextColor(Color.parseColor("#ffffff"))
                text3.setTextColor(Color.parseColor("#ffffff"))
                text4.setTextColor(Color.parseColor("#C2FF41"))
                text5.setTextColor(Color.parseColor("#ffffff"))
                text6.setTextColor(Color.parseColor("#ffffff"))
                linearLayout1.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout2.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout3.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout4.setBackgroundResource(R.drawable.rounded_corner_box_selected)
                linearLayout5.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout6.setBackgroundResource(R.drawable.rounded_corner_box)

            }
            R.id.LinearLayoutButton5 -> {
                text1.setTextColor(Color.parseColor("#ffffff"))
                text2.setTextColor(Color.parseColor("#ffffff"))
                text3.setTextColor(Color.parseColor("#ffffff"))
                text4.setTextColor(Color.parseColor("#ffffff"))
                text5.setTextColor(Color.parseColor("#C2FF41"))
                text6.setTextColor(Color.parseColor("#ffffff"))
                linearLayout1.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout2.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout3.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout4.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout5.setBackgroundResource(R.drawable.rounded_corner_box_selected)
                linearLayout6.setBackgroundResource(R.drawable.rounded_corner_box)

            }
            R.id.LinearLayoutButton6 -> {
                text1.setTextColor(Color.parseColor("#ffffff"))
                text2.setTextColor(Color.parseColor("#ffffff"))
                text3.setTextColor(Color.parseColor("#ffffff"))
                text4.setTextColor(Color.parseColor("#ffffff"))
                text5.setTextColor(Color.parseColor("#ffffff"))
                text6.setTextColor(Color.parseColor("#C2FF41"))
                linearLayout1.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout2.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout3.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout4.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout5.setBackgroundResource(R.drawable.rounded_corner_box)
                linearLayout6.setBackgroundResource(R.drawable.rounded_corner_box_selected)

            }
        }
    }

    fun changeColor(textView: TextView, isClicked: BooleanArray){

        for ((idx,item) in isClicked.withIndex()){
            if(isClicked[idx]){


            }else{

            }
        }

    }


//    linearLayout.setBackgroundResource(R.drawable.rounded_corner_box_selected)
//    text1.setTextColor(Color.parseColor("#C2FF41"))
//    text2.setTextColor(Color.parseColor("#ffffff"))
//    text3.setTextColor(Color.parseColor("#ffffff"))
//    text4.setTextColor(Color.parseColor("#ffffff"))
//    text5.setTextColor(Color.parseColor("#ffffff"))
//    text6.setTextColor(Color.parseColor("#ffffff"))
}