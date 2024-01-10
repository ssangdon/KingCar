package com.example.kingcar

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.example.kingcar.model.ApiResponse
import com.example.test.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        isButtonValid()
        goNextPage()
    }
    @SuppressLint("ResourceAsColor")
    fun isButtonValid(){
        val button = findViewById<Button>(R.id.nextButton)
        val textField = findViewById<EditText>(R.id.nickNameTextField)
        textField.addTextChangedListener{
            val nickname = textField.text.toString()
            if(nickname.isEmpty()){
                button.setBackgroundColor(Color.parseColor("#898F96"))
                button.isEnabled = false
            }else{
                button.setBackgroundColor(Color.parseColor("#C2FF41"))
                button.isEnabled = true
            }
        }
    }
    private fun goNextPage(){
        val button = findViewById<Button>(R.id.nextButton)
        val textField = findViewById<EditText>(R.id.nickNameTextField)
        button.setOnClickListener{
            val intent = Intent(this, MainBoardActivity::class.java)
            intent.putExtra("nickname", textField.text.toString())
            startActivity(intent)
        }
    }



}