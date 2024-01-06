package com.example.test

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        isButtonValid()
        goNextPage()
    }
    @SuppressLint("ResourceAsColor")
    fun isButtonValid(){
        val button = findViewById<Button>(R.id.nextButton)
        val textField = findViewById<EditText>(R.id.nickNameTextField)
        textField.addTextChangedListener{
            val nickname = textField.text.toString()
//            닉네임 중복검사 로직 필요
            if(nickname.isEmpty()){
                button.setBackgroundColor(Color.parseColor("#898F96"))
                button.isEnabled = false

            }else{
                button.setBackgroundColor(Color.parseColor("#C2FF41"))
                button.isEnabled = true
            }

        }
    }
    fun goNextPage(){
        val button = findViewById<Button>(R.id.nextButton)
        button.setOnClickListener{
            val intent = Intent(this, CarSelectActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}