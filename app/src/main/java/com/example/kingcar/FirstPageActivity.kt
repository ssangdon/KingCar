package com.example.kingcar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.test.R

class FirstPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_page)
        goRegisterPage();
        goLoginPage();
    }
    fun goLoginPage(){
        val button = findViewById<Button>(R.id.loginButton)
        button.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
    private fun goRegisterPage(){
        val button = findViewById<Button>(R.id.registerButton)
        button.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
    fun goNextPage(){
        val button = findViewById<Button>(R.id.nextButton)
        button.setOnClickListener{
            val intent = Intent(this, MainBoardActivity::class.java)
            startActivity(intent)
        }
    }
}